package pe.com.inetum.cop.msnecopconsulta.business;

import pe.com.inetum.cop.msnecopconsulta.expose.request.PublicationRequest;
import reactor.core.publisher.Mono;

public interface PublicationService {
  Mono<String> savePublication(PublicationRequest publicationRequest,String usuario);
}
