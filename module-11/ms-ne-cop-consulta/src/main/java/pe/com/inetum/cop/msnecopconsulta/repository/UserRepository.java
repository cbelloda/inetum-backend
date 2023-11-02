package pe.com.inetum.cop.msnecopconsulta.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.inetum.cop.msnecopconsulta.model.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByName(String name);
  
}
