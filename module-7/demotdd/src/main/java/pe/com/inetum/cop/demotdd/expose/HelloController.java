package pe.com.inetum.cop.demotdd.expose;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


  public String sayHello(){
    return " hello ";
  }

  
}
