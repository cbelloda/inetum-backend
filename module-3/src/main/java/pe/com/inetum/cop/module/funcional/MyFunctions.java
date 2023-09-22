package pe.com.inetum.cop.module.funcional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import lombok.extern.java.Log;

@Log
public class MyFunctions {


  public static void execute(){

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

        Function<Person,Integer> lenName = person -> person.getName().length();

          log.info("La longitu del nombre de la person1 es "+ lenName.apply(person1));
          log.info("La longitu del nombre de la person1 es "+ lenName.apply(person2));

      Integer factor = 10;

      /*if(person2.getAge()==10){
            factor = 200;
      }*/

      Function<Integer,Integer> multiplicarFactor = x -> x*factor;
      Function<Integer,Integer> sumFactor = x -> x + factor;

      
      log.info("and then ----->  "+multiplicarFactor.andThen(sumFactor).apply(2));

      log.info("compose ----->  "+multiplicarFactor.compose(sumFactor).apply(2));



      BiFunction<Integer,Integer,Integer>  sumelements = (a,b) -> a+b;


          log.info("suma de elementos --->  "  + sumelements.apply(10,11));



      UnaryOperator<IntBinaryOperator> operator = op -> op::applyAsInt;

      IntBinaryOperator  suma = operator.apply((a,b)->a+b);
      IntBinaryOperator  resta = operator.apply((a,b)->a-b);
      IntBinaryOperator  multiplicacion = operator.apply((a,b)->a*b);      


      log.info("suma --->  "+suma.applyAsInt(10,20));
      log.info("resta --->  "+resta.applyAsInt(20,7));
      log.info("multiplicacion --->  "+multiplicacion.applyAsInt(4,8));


Consumer<String> consumer =   value -> log.info("EL valor es "+value);


consumer.accept("1");
consumer.accept("2");
consumer.accept("3");
consumer.accept("4");


Supplier<Person>  getPersonOld = ()->Person.builder()
.name("CArl0")
.age(100)
.category(Category.PREMIUM)
.build();


        log.info("person " + getPersonOld.get());
        log.info("person " + getPersonOld.get());
        log.info("person " + getPersonOld.get());
        log.info("person " + getPersonOld.get());




  }
  
}
