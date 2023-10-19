package pe.com.inetum.cop.demo.expose;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.inetum.cop.demo.service.MyService;

@RestController
@RequestMapping("/greetings")
@RequiredArgsConstructor
public class HelloWorldController {

  
  private final MyService myService;
  

  @GetMapping("/say")
  public String saySomething(){
    return "Hola mundo spring boot " + myService.aMethod();
  }

  
  
}
