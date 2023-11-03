package pe.com.inetum.cop.msnecopconsulta.expose;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.inetum.cop.msnecopconsulta.business.PublicationService;
import pe.com.inetum.cop.msnecopconsulta.business.TypeUser;
import pe.com.inetum.cop.msnecopconsulta.expose.request.PublicationRequest;
import pe.com.inetum.cop.msnecopconsulta.expose.response.Notification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/publications")
@RequiredArgsConstructor
public class PublicationController {

  private final PublicationService publicationService;
  private final Sinks.Many<Notification> notificationSink;

  @GetMapping("/notifications/{typeUser}")
  public Flux<String> getNotifications(@PathVariable TypeUser typeUser) {
    return notificationSink.asFlux()    
    .filter(publication -> {
      System.out.println("************************************" + publication.getTypeUser());      
      System.out.println("************************************" + typeUser);      
      System.out.println("###############"+publication.getTypeUser().equals(typeUser));
      return publication.getTypeUser().equals(typeUser);
    })
    .map(value -> {
      System.out.println("----------------------------->" + value);
      return value.toString()+"\n";
    }
      )
    .log()
    ;
  }

  @PostMapping("/save")
  public Mono<String> savePublication(@Valid @RequestBody PublicationRequest publicationRequest,
      @RequestHeader("application-user") String applicationUser) {
    return publicationService.savePublication(publicationRequest, applicationUser);
  }

}
