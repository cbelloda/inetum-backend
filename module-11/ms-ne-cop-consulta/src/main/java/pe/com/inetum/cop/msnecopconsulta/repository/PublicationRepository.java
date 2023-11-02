package pe.com.inetum.cop.msnecopconsulta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.inetum.cop.msnecopconsulta.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{
  
}
