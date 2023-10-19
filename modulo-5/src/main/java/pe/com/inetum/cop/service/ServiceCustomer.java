package pe.com.inetum.cop.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pe.com.inetum.cop.lazy.Lazy;
import pe.com.inetum.cop.repository.Category;
import pe.com.inetum.cop.repository.Customer;
import pe.com.inetum.cop.repository.CustomerRepository;
import pe.com.inetum.cop.webclient.WebClient;

public class ServiceCustomer {

  public String getSaludo(Long id) {

    return CustomerRepository.getACustomer(id)
        .map(customer -> new SaludoService().eval(customer))
        .orElseThrow(() -> new RuntimeException("El usuario con id " + id + " no existe "));
  }

  public List<String> getAll() {

    return CustomerRepository.getAllCustomer()
        .stream()
        .map(customer -> this.getSaludo(customer.getId()))
        .collect(Collectors.toList());

  }

  public List<Response> getCalculateResponse() {
    
    if (WebClient.shouldcalculate()){
      return List.of();
    }

    List<Customer> customerList = CustomerRepository.getAllCustomer();

    return customerList.stream()
        .map(customer -> Response.builder()
            .name(customer.getName())
            .saludo(this.getSaludo(customer.getId()))
            .accounts(calculateAccounts(customer,customerList))
            .build())
        .collect(Collectors.toList())
        ;
  }

  public List<Response> getCalculateResponse2() {
    
    Lazy<List<Customer>> customerList = Lazy.<List<Customer>>builder()
    .supplier(CustomerRepository::getAllCustomer)
    .build();

    return WebClient.shouldcalculate()?customerList.get().stream()
        .map(customer -> Response.builder()
            .name(customer.getName())
            .saludo(this.getSaludo(customer.getId()))
            .accounts(calculateAccounts(customer,customerList.get()))
            .build())
        .collect(Collectors.toList()):List.of()
        ;
  }

  private Map<Category, Long> calculateAccounts(Customer customer, List<Customer> customers) {

    return customers.stream()
        .filter(cus -> !cus.getId().equals(customer.getId()))
        .collect(Collectors.groupingBy(Customer::getCategory, Collectors.counting()));

  }

}
