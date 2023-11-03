package pe.com.inetum.cop.msnecopconsulta.expose;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import pe.com.inetum.cop.msnecopconsulta.business.PublicationService;
import pe.com.inetum.cop.msnecopconsulta.expose.request.PublicationRequest;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = PublicationController.class)
class PublicationControllerTest {

  @Autowired
  WebTestClient webTestClient;

  @MockBean
  PublicationService publicationService;

  @Test
  void shouldSaveAPublicationAndReturnAnewCode() {
    PublicationRequest publicationRequest = PublicationRequest.builder()
        .title("title")
        .description("description")
        .build();

    when(publicationService.savePublication(
        argThat(publicationRequestMatcher -> publicationRequestMatcher.getTitle().equals(publicationRequest.getTitle())
            && publicationRequestMatcher.getDescription().equals(publicationRequest.getDescription())),
        eq("cbelloda")))
        .thenReturn(Mono.just("code"));
    ;

    webTestClient.post()
        .uri("/publications/save")
        // .bodyValue("{\"title\":\"title\",\"description\":\"description\"}")
        .body(BodyInserters.fromValue(publicationRequest))
        .header("application-user", "cbelloda")
        .header("Content-Type", "application/json")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class)
        .isEqualTo("code");
  }

  @Test
  void shouldReturnABadRequestDueToHeaderApplicationUserFail() {

    PublicationRequest publicationRequest = PublicationRequest.builder()
        .title("title")
        .description("description")
        .build();

    when(publicationService.savePublication(
        any(),
        any()))
        .thenReturn(Mono.just("code"));
    ;

    webTestClient.post()
        .uri("/publications/save")
        .bodyValue("{\"title\":\"title\",\"description\":\"description\"}")
        .header("Content-Type", "application/json")
        .exchange()
        .expectStatus().is4xxClientError();

  }

@Test
void shouldReturnAnErrorDuetoTitleNull(){

    
    when(publicationService.savePublication(
        any(),
        any()))
        .thenReturn(Mono.just("code"));
    ;

    webTestClient.post()
        .uri("/publications/save")
         .bodyValue("{\"description\":\"description\"}")        
        .header("application-user", "cbelloda")
        .header("Content-Type", "application/json")
        .exchange()
        .expectStatus().is4xxClientError();

}  

}
