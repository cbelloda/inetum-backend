package pe.com.inetum.cop.msnecopconsulta.business;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.inetum.cop.msnecopconsulta.business.impl.PublicationServiceDefault;
import pe.com.inetum.cop.msnecopconsulta.expose.request.PublicationRequest;
import pe.com.inetum.cop.msnecopconsulta.model.Publication;
import pe.com.inetum.cop.msnecopconsulta.model.User;
import pe.com.inetum.cop.msnecopconsulta.repository.PublicationRepository;
import pe.com.inetum.cop.msnecopconsulta.repository.UserRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class PublicationServiceDefaulTest {

  @Mock
  UserRepository userRepository;

  @Mock
  PublicationRepository publicationRepository;

  @Mock
  NotificationService notificationService;

  @InjectMocks
  PublicationServiceDefault publicationService;

    @Captor
  ArgumentCaptor<Publication> publicationCaptor;

  @Test
  void shouldSaveInDBARequestForPublication() {

    String usuario = "cbelloda";
    PublicationRequest publicationRequest = PublicationRequest.builder()
        .description("a description")
        .title("title")
        .build();

    LocalDate now = LocalDate.now();

    Optional<User> userFinded = Optional.of(User.builder()
        .dateCreated(now)
        .email("cbelloda@gmail.com")
        .id(1L)
        .name(usuario)
        .build());

    when(userRepository.findByName(eq(usuario))).thenReturn(userFinded);

    Publication newPublication = Publication.builder()
        .title("Title")
        .description("a description")
        .dateCreated(now)
        .user(userFinded.get())
        .id("codigo uuu id ")        
        .build();

    when(publicationRepository
        .save(publicationCaptor.capture()))
        .thenReturn(newPublication);       

    Mono<String> responseSave = publicationService.savePublication(publicationRequest, usuario);


  StepVerifier.create(responseSave)
        .expectNextMatches(response -> {         
          return UUID.fromString(publicationCaptor.getValue().getId()).toString()
          .equals(publicationCaptor.getValue().getId()) && response.equals("codigo uuu id ");
        }).verifyComplete();      

    verify(publicationRepository, times(1)).save(any());

    

  
  }

  @Test
  void shouldReturnErrorBecauseUserIsNotFound(){

    String usuario = "cbelloda";
    PublicationRequest publicationRequest = PublicationRequest.builder()
        .description("a description")
        .title("title")
        .build();       

    when(userRepository.findByName(eq(usuario))).thenReturn(Optional.empty());
    Mono<String> responseSave = publicationService.savePublication(publicationRequest, usuario);

    StepVerifier.create(responseSave)
      .expectErrorMatches(throwable->  throwable instanceof RuntimeException).verify();

  

    

  }

    @Test
  void shouldSaveInDBARequestForPublicationAndCallNotification() {

    String usuario = "cbelloda";
    PublicationRequest publicationRequest = PublicationRequest.builder()
        .description("a description")
        .title("title")
        .build();

    LocalDate now = LocalDate.now();

    Optional<User> userFinded = Optional.of(User.builder()
        .dateCreated(now)
        .email("cbelloda@gmail.com")
        .id(1L)
        .name(usuario)
        .build());

    when(userRepository.findByName(eq(usuario))).thenReturn(userFinded);
    

    Publication newPublication = Publication.builder()
        .title("Title")
        .description("a description")
        .dateCreated(now)
        .user(userFinded.get())
        .id("codigo uuu id ")        
        .build();

    when(publicationRepository
        .save(publicationCaptor.capture()))
        .thenReturn(newPublication);       

    Mono<String> responseSave = publicationService.savePublication(publicationRequest, usuario);


  StepVerifier.create(responseSave)
        .expectNextMatches(response -> {         
          return UUID.fromString(publicationCaptor.getValue().getId()).toString()
          .equals(publicationCaptor.getValue().getId()) && response.equals("codigo uuu id ");
        }).verifyComplete();      

    verify(publicationRepository, times(1)).save(any());

    verify(notificationService, times(1)).notify(any(), any(),any());

  
  }


}
