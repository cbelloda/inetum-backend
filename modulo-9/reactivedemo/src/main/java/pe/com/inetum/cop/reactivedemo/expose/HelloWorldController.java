package pe.com.inetum.cop.reactivedemo.expose;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.inetum.cop.reactivedemo.business.HelloService;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
  

  private final HelloService  helloService;

@GetMapping("/say/something")
public Mono<String> saySomething(){
  return Mono.just("Hello World");
}

@GetMapping("/anumber")
public Mono<Integer> getValue() throws InterruptedException{
  return helloService.getValue();
}

}
