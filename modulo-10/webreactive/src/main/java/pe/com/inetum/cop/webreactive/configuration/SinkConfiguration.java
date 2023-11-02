package pe.com.inetum.cop.webreactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

@Configuration
public class SinkConfiguration {

  @Bean
  public Sinks.Many<String> getSink(){
    return Sinks.many().multicast().onBackpressureBuffer();
  }
  
}
