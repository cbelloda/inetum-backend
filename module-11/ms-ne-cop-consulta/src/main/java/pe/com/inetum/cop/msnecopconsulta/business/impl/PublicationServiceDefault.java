package pe.com.inetum.cop.msnecopconsulta.business.impl;

import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.inetum.cop.msnecopconsulta.business.NotificationService;
import pe.com.inetum.cop.msnecopconsulta.business.PublicationService;
import pe.com.inetum.cop.msnecopconsulta.expose.request.PublicationRequest;
import pe.com.inetum.cop.msnecopconsulta.model.Publication;
import pe.com.inetum.cop.msnecopconsulta.repository.PublicationRepository;
import pe.com.inetum.cop.msnecopconsulta.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PublicationServiceDefault implements PublicationService {

  private final UserRepository userRepository;
  private final PublicationRepository publicationRepository;
  private final NotificationService notificationService;

  @Override
  public Mono<String> savePublication(PublicationRequest publicationRequest, String usuario) {

    return Mono
        .fromCallable(
            () -> userRepository.findByName(usuario)
            .orElseThrow(() -> new RuntimeException("User not found")))
        // .filter(Optional::isPresent)
        // .map(userOPtional -> userOPtional.get())
        .map(user -> publicationRepository.save(Publication.builder()
            .description(publicationRequest.getDescription())
            .title(publicationRequest.getTitle())
            .id(UUID.randomUUID().toString())
            .dateCreated(LocalDate.now())
            .user(user)
            .build()))
        .doOnNext(publication -> notificationService.notify(publication.getTitle(),
        publication.getTitle(),
        publication.getUser().getType()
        ))    
        .map(Publication::getId)        
        ;

  }

}
