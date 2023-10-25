package pe.com.inetum.cop.demotdd.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="AUTOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Long id;

@Column(name="nombre")
private String name;

@Column(name="numero_documento")
private String documentNumber;

@Column(name="date_created")
private LocalDate data;

@Column(name="email")
private String email;

@Column(name="status")
private Integer status; 

@OneToMany(mappedBy = "author")
private Set<AuthorBook> authorBook;



}
