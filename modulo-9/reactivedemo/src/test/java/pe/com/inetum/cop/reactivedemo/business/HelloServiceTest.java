package pe.com.inetum.cop.reactivedemo.business;

import java.util.List;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class HelloServiceTest {

  @Test
  void shouldreturnAMonoAndFlux(){

    Mono<String> mono = Mono.just("Hola Mundo")
    .log()
    ;


    StepVerifier.create(mono).expectNextMatches(m -> m.contains("Hola"))
    .verifyComplete()
    ;

  }

@Test
void shouldReturnMonoFromList(){

  Mono<Integer> pub1 = Mono.just(1).filter(value-> value==2)
  .flatMap(value -> {
   try{
    return Mono.just(aLargeProccess());
   } catch(InterruptedException ex){
    System.out.println(ex);
    return Mono.just(-1);
   }
  }
    );

    pub1.subscribe();
  
  //Mono.just(aLargeProccess());

//  Mono<Integer> pub2 = Mono.fromCallable(()->aLargeProccess()).log();


  //pub1.subscribe();
  //pub1.subscribe();
  //pub1.subscribe();
//System.out.println("el segundo proceso");
//  pub2.subscribe();
  //pub2.subscribe();
//  System.out.println("el segundo proceso termina");

}

static Integer aLargeProccess() throws InterruptedException{
  System.out.println("Un largo proceso  -->  ");
      Thread.sleep(10000);

      return 10;
}


@Test
void shouldEvaluateswitchIfEmpty(){

    Mono<String> value  = Mono.just("Hola")
    .map(value_ -> value_.equals("Hola")?"A": "AB" )
    .filter(value_ -> value_.length()==1)
    .map(value_ -> "Un nuevo Hola")
    .switchIfEmpty(Mono.just("interesante"))
    ;

    StepVerifier.create(value).expectNext("Un nuevo Hola").verifyComplete();


}



  
  
}
