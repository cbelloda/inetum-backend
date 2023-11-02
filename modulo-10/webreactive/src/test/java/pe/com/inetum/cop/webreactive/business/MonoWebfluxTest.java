package pe.com.inetum.cop.webreactive.business;

import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoWebfluxTest {

  private String methodThatReturnString() {

    System.out.println("Aquí está el método");

    return "Hola";
  }

  @Test
  void shouldCreateOperatorMono() {

    Mono<String> monoString = Mono.just(methodThatReturnString()).log();
    Mono<String> monoFromCallable = Mono.fromCallable(() -> methodThatReturnString()).log();
    Mono<String> monoDefer = Mono.defer(()->Mono.just(methodThatReturnString()));

    monoString.subscribe(System.out::println);

    Mono<String>  anotherMono =   Mono.just("Adios")
    .filter(v -> v.length()>10)
    .flatMap(v -> monoFromCallable);

    anotherMono.subscribe(System.out::println);

    monoFromCallable.subscribe(System.out::println);

  }


  @Test
  void mapFlatMApMono(){
    Mono<Integer>  monoInteger = Mono.just("Hola").map(v -> v.length());

    monoInteger.subscribe(System.out::println);


    Mono<String> monoString = Mono.just(10)
    .flatMap(v ->{
      System.out.println("Aquí entramos al flatMap");
      return Mono.just("Hola Mundo");
    });

    monoString.subscribe(System.out::println);

  }

  @Test
  void shoudlFilterMono(){
    Predicate<Integer> ifValueGreatherthen900 = value -> value > 900;

    Mono<Integer> monoInteger = Mono.just(1000)
    .filter(v->ifValueGreatherthen900.test(v))
    .map(v->1);

    monoInteger.subscribe(System.out::println);


  }

  @Test
  void zipTwoMono(){
      Mono<String> monoHello = Mono.just("Hello");
      Mono<String> monoWorld = Mono.just("World");


    Mono<String> monoResult = monoHello.zipWith(monoWorld).map( tuple ->{


      return tuple.getT1() + tuple.getT2();

    } ) ;


    monoResult.subscribe(System.out::println);



  }
}

