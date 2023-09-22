package pe.com.inetum.cop.service;

import pe.com.inetum.cop.repository.Category;
import pe.com.inetum.cop.repository.CustomerRepository;

public class ServiceCustomer {

  

  public String getSaludo(Long id){

    return CustomerRepository.getACustomer(id)
    //.map(customer -> "Hola " + customer.getName())
    .map(customer ->new SaludoService().eval(customer))
    .orElseThrow(()->new RuntimeException("El usuario con id "+ id +" no existe "))
    ;


  }


  
}
