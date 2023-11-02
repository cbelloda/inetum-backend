package pe.com.inetum.cop.reactivedemo.business;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HelloService {


  public Mono<Integer> getValue() throws InterruptedException{

        // Mono<Integer> value1 =      Mono.just(aLargeProccess());

        Mono<Integer> value2 =      Mono.fromCallable(()->aLargeProccess());

       // aLargeProccess();

         return Mono.just(90).flatMap(value ->  {
          try{
               Mono.just(aLargeProccess()).map(v ->900 );
          }catch(InterruptedException ex){

          }
          return Mono.just(80);
          }
          );

  }
  
  private static Integer aLargeProccess() throws InterruptedException{
    System.out.println("Un largo proceso  -->  ");
        Thread.sleep(10000);
  System.out.println("acabó ");
        return 10;
  }
}
