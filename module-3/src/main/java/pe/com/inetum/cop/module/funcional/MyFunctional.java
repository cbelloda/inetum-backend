package pe.com.inetum.cop.module.funcional;

import java.util.function.Function;
import java.util.function.Predicate;
import lombok.extern.java.Log;

@Log
public class MyFunctional {

  public static void execute() {

    MyInterface expresionLambda = name -> (double) name.length();
    MyInterface expresionLambda2 = name -> (double) name.length() + 200;

    log.info("la longitud " + expresionLambda.getPrice("Carlos"));
    log.info("la longitud__ " + expresionLambda.getPrice("Belloda"));
    log.info("la longitud___ " + expresionLambda.getPrice("Saavedra"));

    log.info("" + expresionLambda2.getPrice("jajajajajajaj"));

    Person person1 = Person.builder()
        .age(50)
        .name("Carlos")
        .category(Category.PREMIUM)
        .build();

     Person person2 = Person.builder()
        .age(20)
        .name("Enrique")
        .category(Category.PREMIUM)
        .build();   

        Predicate<Person> isLessThan25  = p -> p.getAge()<25;
        Predicate<Person> isPremium = p -> p.getCategory().equals(Category.PREMIUM);

    log.info("person1 isLessThan25 test " + isLessThan25.test(person1));
    log.info("person2 isLessThan25 test " + isLessThan25.test(person2));

    log.info("person1 is premium test " + isPremium.test(person1));
    log.info("person2 is premium test " + isPremium.test(person2));

    Predicate<Person> isLes25AndPremium = isLessThan25.and(isPremium);

    log.info("person1 is premium and less test " + isLes25AndPremium.test(person1));

    log.info("person2 is premium and less test " + isLessThan25.and(isPremium).test(person2));


    Function<Person, Double> calculateMoney =  p -> (double)p.getAge() + 100 * 340;


    log.info("value  -->  " + calculateMoney.apply(person1));




  }
}
