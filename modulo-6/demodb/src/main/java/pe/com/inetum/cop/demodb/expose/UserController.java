package pe.com.inetum.cop.demodb.expose;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.inetum.cop.demodb.model.Usuario;
import pe.com.inetum.cop.demodb.repository.UsuarioJpaRepository;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UsuarioJpaRepository usuarioJpaRepository;

  @GetMapping("/all")
public List<Usuario> getAll(){
    return usuarioJpaRepository.findAll();
}
  
}
