package pe.com.inetum.cop.demotdd.model;

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

@Entity
@Table(name = "AUTOR_LIBRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorBook {

  @Id
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_autor")
  private Author author;

  @ManyToOne
  @JoinColumn(name = "id_libro")
  private Book book;

  @Column(name = "tipo")
  private String type;
  @Column(name = "date_created")
  private LocalDate dateCreated;

}
