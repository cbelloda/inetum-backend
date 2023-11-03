package pe.com.inetum.cop.msnecopconsulta.expose;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.inetum.cop.msnecopconsulta.repository.UserRepository;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final UserRepository userRepository;

  @GetMapping("/")
  public Mono<List<String>> hello() {

    return Mono.just(userRepository.findAll()
        .stream()
        .map(s -> s.getName())
        .collect(Collectors.toList()));
  }

  

}
