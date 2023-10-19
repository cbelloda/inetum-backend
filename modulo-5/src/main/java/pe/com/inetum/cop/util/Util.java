package pe.com.inetum.cop.util;

import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import pe.com.inetum.cop.repository.Customer;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

  public static final Predicate<Customer> isoldThan40 = customer -> customer.getAge()>40;
  public static final Predicate<Customer> islessThan40 = customer -> customer.getAge()<40;
  
}
