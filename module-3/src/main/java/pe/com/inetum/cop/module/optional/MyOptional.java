package pe.com.inetum.cop.module.optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import lombok.extern.java.Log;
import pe.com.inetum.cop.module.funcional.Person;

@Log
public class MyOptional {


  public static void execute(){


    Person personWithoutName =  Repository.getAPerson();

    Optional<Person> personOptional = Optional.of(personWithoutName);

    Predicate<Person> isOld = person -> person.getAge()>20;
    Function<Person,Integer> toAgePrice = person ->  person.getAge()+100;

    Integer resultado =   
    Optional.of(personWithoutName)
    .filter(isOld::test)//.filter(person -> isOld.test(person))
    .map(toAgePrice::apply) // map(person ->  person.getAge()+100)    
    .orElseThrow(()->new IllegalArgumentException("Mi propia exception "))
    ;

    Optional<Integer> asd = Optional.of(personWithoutName)
    .filter(isOld::test)//.filter(person -> isOld.test(person))
    .map(toAgePrice::apply);

    log.info("optional de integer --->  "+resultado);

    log.info("la edad --> " + personOptional.get().getAge());

    
    log.info("la longitud de su nombre es "+  personWithoutName.getName().length());

  }


  
}
