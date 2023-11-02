package pe.com.inetum.cop.webnormal.expose;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


  @GetMapping("/say/something")
  public String saySomething() throws InterruptedException{
    System.out.println("hilo" + Thread.currentThread());
    Thread.sleep(5000);
    return "Hola";
  }
  
}
