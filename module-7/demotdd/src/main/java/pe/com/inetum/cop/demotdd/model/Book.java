package pe.com.inetum.cop.demotdd.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import liquibase.pro.packaged.id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="LIBRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
  
@Id
@Column(name="id")
String id;

@Column(name="titulo")
String title;

@Column(name="descripcion")
String description;

@Column(name="date_created")
LocalDate dateCreated;  


@OneToMany(mappedBy = "book")
private Set<AuthorBook> authorBook;

}
