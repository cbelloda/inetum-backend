package pe.com.inetum.cop.msnecopconsulta.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.inetum.cop.msnecopconsulta.expose.response.Notification;
import reactor.core.publisher.Sinks;

@Configuration
public class ConfigurationSinks {

  @Bean
  public Sinks.Many<Notification> notificationSink() {
    return Sinks.many().multicast().onBackpressureBuffer();
  }
  
}
