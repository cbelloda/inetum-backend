package pe.com.inetum.cop.strategy;

import java.util.List;
import java.util.function.Predicate;
import lombok.extern.java.Log;

@Log
public class MyStrategy {

  public static Integer calculate(List<Integer> numbers,Predicate<Integer> strategy){
    Integer sum =0;
    for(Integer n : numbers){
      if(strategy.test(n)){
        sum = sum + n;
      }      
    }
    return sum;
  }

//   public static Integer calculateEven(List<Integer> numbers){
//    Integer sum =0;
//    for(Integer n : numbers){
//      if(n % 2 ==0){
//        sum = sum + n;
//      }      
//    }
//    return sum;
//  }


  public static void execute(){
      List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);


      log.info("La suma de los números es " + calculate(numbers,n->true));
      log.info("La suma de los números pares es " + calculate(numbers,n->n%2==0));
  

      



  }
  
}
