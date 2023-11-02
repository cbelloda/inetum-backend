package pe.com.inetum.cop.demotdd.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.com.inetum.cop.demotdd.model.Author;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class AuthorRepositoryTest {

  @Autowired
  TestEntityManager testEntityManager;

  @Autowired
  AuthorRepository authorRepository; 

  @Test
  void shouldReturnListAuthor(){
      List<Author> authorList =  authorRepository.findAll();

    assertTrue(authorList.size()==5);

  }

@Test
  void shouldReturnListAndAddAuthor(){

    Author newAuthor = Author.builder()
    .email("cbelloda@gmail.com")
    .data(LocalDate.now())
    .documentNumber("43843823")
    .name("Carlos")
    .status(1)
    .build();

      authorRepository.save(newAuthor);

      List<Author> authorList =  authorRepository.findAll();

    assertTrue(authorList.size()==6);

  }

  
}
