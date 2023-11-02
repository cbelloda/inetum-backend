package pe.com.inetum.cop.webreactive.expose;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final Sinks.Many<String> sink;

@GetMapping("/say/something")
public Mono<String> saySomething(){
  
  return Mono.just("Hola").delayElement(Duration.ofSeconds(5)).log();

}


@GetMapping("/send")
public void  setValueSink(){
    sink.tryEmitNext("Hola el elemento es " + Math.random());
}


@GetMapping("/stream")
public Flux<String>  getStream(){
  return sink.asFlux();
}
  
  
}
