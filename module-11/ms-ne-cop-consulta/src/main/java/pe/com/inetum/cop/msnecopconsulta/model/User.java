package pe.com.inetum.cop.msnecopconsulta.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="nombre")
  private String name;

  @Column(name="email")
  private String email;

  @Column(name="estado")
  private int status;

  @Column(name="tipo")
  private String type;

  @Column(name="date_created")
  private LocalDate dateCreated;

  @OneToMany(mappedBy = "user")
  private Set<Publication> publications;



  
}
