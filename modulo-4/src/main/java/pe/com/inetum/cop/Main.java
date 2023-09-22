package pe.com.inetum.cop;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.java.Log;
import pe.com.inetum.cop.repository.Customer;
import pe.com.inetum.cop.repository.CustomerRepository;
import pe.com.inetum.cop.service.ServiceCustomer;

import static pe.com.inetum.cop.util.Util.isoldThan40;
import static pe.com.inetum.cop.util.Util.islessThan40;

@Log
public class Main {

  public static void main(String[] args) {


log.info("1 : -> " + new  ServiceCustomer() .getSaludo(1L));
log.info("2 : -> " + new  ServiceCustomer() .getSaludo(2L));
log.info("3 : -> " + new  ServiceCustomer() .getSaludo(3L));
log.info("4 : -> " + new  ServiceCustomer() .getSaludo(4L));
log.info("5 : -> " + new  ServiceCustomer() .getSaludo(5L));

    /*
       
      List<Customer> customerFilter =  CustomerRepository.getAllCustomer()
          .stream()
          .filter(isoldThan40)
          .collect(Collectors.toList())
          ;


        log.info("Los clientes filtrados -->  "+customerFilter);


        Stream<Customer> streamlessThan40 = CustomerRepository.getAllCustomer()
          .stream()
          .filter(islessThan40);


        List<Customer> list1 = streamlessThan40.collect(Collectors.toList())  ;

        //List<Customer> list2 = streamlessThan40.collect(Collectors.toList())  ;

        log.info("  ---> list 1 "+ list1  );
        //log.info("  ---> list 2 "+ list2  );



         List<Integer> ageCustomer = CustomerRepository.getAllCustomer()
          .stream()
          .filter(islessThan40)
          .map(Customer::getAge)
          .collect(Collectors.toList())
          ;

          log.info(" edades  --> " + ageCustomer);


//          flatMap  -->  es un map  pero que hace una operación de flat .







 List<Integer> numbers = CustomerRepository.getAllCustomer()
          .stream()
          .filter(islessThan40)
          .flatMap(customer -> {
              // hacermuchas cosas aquí  --> retorne un stream
              // [1,2,3,4,5,6]

            //return customer.getAge();
                    
            return List.of(1,2,3,4,5).stream();
          })
          .collect(Collectors.toList())
          ;
          log.info("numbers with flatMap ---> "  +numbers);


*/

  }
  
}
