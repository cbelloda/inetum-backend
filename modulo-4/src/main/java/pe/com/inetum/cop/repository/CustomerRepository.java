package pe.com.inetum.cop.repository;

import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerRepository {


  public static Optional<Customer> getACustomer(Long id){
      return getAllCustomer().stream()
      .filter(customer -> customer.getId().equals(id))
      .findFirst();

  }

  public static List<Customer> getAllCustomer() {

    Customer c1 = Customer.builder().name("Carlos")
        .age(30)
        .category(Category.REGULAR)
        .id(1l).build();
    Customer c2 = Customer.builder().name("Samantha")
        .age(10)
        .category(Category.BASIC)
        .id(2l).build();
    Customer c3 = Customer.builder().name("Juan")
        .age(50)
        .category(Category.PREMIUM)
        .id(3l).build();

    Customer c4 = Customer.builder().name("Sandra")
        .age(60)
        .category(Category.PREMIUM)
        .id(4l).build();

    return List.of(c1, c2, c3, c4);

  }

}
