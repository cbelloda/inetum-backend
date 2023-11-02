package pe.com.inetum.cop.demotdd.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.inetum.cop.demotdd.expose.response.AuthorResponse;
import pe.com.inetum.cop.demotdd.model.Author;
import pe.com.inetum.cop.demotdd.model.AuthorBook;
import pe.com.inetum.cop.demotdd.model.Book;
import pe.com.inetum.cop.demotdd.repository.AuthorRepository;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

  @Mock
  AuthorRepository authorRepository;

  @InjectMocks
  AuthorService authorService;

  @Test
  void shouldReturnAnAuthorandEvaluateheName(){

    when(authorRepository.findById(1l))
    .thenReturn(Optional.of(Author.builder().name("Carlos").build()));

        AuthorResponse authorResponse = authorService.findById(1l);
        assertEquals("Carlos",authorResponse.getName());
  }

  @Test
  void shouldReturAnAuthorAnBooks() {
    Book bookA = Book.builder()
        .description("A Book")
        .build();
    Book bookB = Book.builder()
        .description("B Book")
        .build();

    Set<AuthorBook> authorBooks = Set.of(
        AuthorBook.builder()
            .book(bookA)
            .build(),
        AuthorBook.builder()
            .book(bookB)
            .build());

    Optional<Author> authorModel = Optional.of(Author.builder()
        .name("Carlos")
        .email("cbelloda@gmail.com")
        .documentNumber("43843823")
        .status(1)
        .authorBook(authorBooks)
        .build())

    ;
    when(authorRepository.findById(1l)).thenReturn(authorModel);
          AuthorResponse authorResponse = authorService.findById(1L);


          assertEquals(2,authorResponse.getBooks().size());


  }

}
