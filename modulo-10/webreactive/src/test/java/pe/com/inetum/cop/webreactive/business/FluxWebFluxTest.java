package pe.com.inetum.cop.webreactive.business;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class FluxWebFluxTest {

  @Test 
  void shouldCreateFlux(){

    Flux<String> fluxString = Flux.just("A","B","C");
    Flux<Integer> fluxInteger = Flux.just(1,2,3,4);

fluxString.subscribe(System.out::println);
fluxInteger.subscribe(System.out::println);   

  }

  @Test 
  void shouldCreateMapFlatMApFilterFlux(){

    Flux<Integer>  fluxInteger = Flux.range(1,10);

    Flux<String>  fluxString = Flux.just("A","B","C");

    Flux<Integer> fluxResult =  fluxString
    .filter(value -> value.matches("A|B"))
    .flatMap(value -> fluxInteger);

fluxResult.subscribe(System.out::println);   
  }

  @Test 
  void shoudlManipulateTIme() throws InterruptedException{

      Flux<Integer>  fluxInteger = Flux.range(1,10).delayElements(Duration.ofSeconds(2));

      fluxInteger.subscribe(System.out::println);

      Thread.sleep(20000);

  }

  @Test 
  void joinFLux(){
Flux<String>  fluxString = Flux.just("A","B","C");
Flux<String>  fluxStringNumber = Flux.just("1","2","3");    
        Flux<String> concatWithFlux  =     fluxString.concatWith(fluxStringNumber);

        concatWithFlux.subscribe(System.out::println);

  }

  @Test
  void emitterProgramaticallyFlux(){
    Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

    Flux<Object> objects = sink.asFlux();

    objects.subscribe(System.out::println);
 

    sink.tryEmitNext("Hi");
    sink.tryEmitNext("Hello");
    sink.tryEmitNext("Hola");
    sink.tryEmitNext("Mundo");



  }


  
}
