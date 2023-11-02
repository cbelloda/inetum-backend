package pe.com.inetum.cop.msnecopconsulta.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "publicacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Publication {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "titulo")
  private String title;

  @Column(name = "descripcion")
  private String description;

  @Column(name = "date_created")
  private LocalDate dateCreated;

  @ManyToOne
  @JoinColumn(name = "usuario")
  private User user;

}
