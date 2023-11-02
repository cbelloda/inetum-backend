package pe.com.inetum.cop.demotdd.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.inetum.cop.demotdd.expose.response.AuthorResponse;
import pe.com.inetum.cop.demotdd.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorService {

  // retorne un autor por un id

  private final AuthorRepository authorRepository;

  public AuthorResponse findById(Long id) {

    return authorRepository.findById(id)
        .map(AuthorResponse.MAPPER::apply)
        .orElseThrow(() -> new RuntimeException("No pude obtener el autor"));
  }

}
