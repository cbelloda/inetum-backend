package pe.com.inetum.cop.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {


  @Bean
  public String getName(){
    return "Carlos Belloda";
  }
  
}
