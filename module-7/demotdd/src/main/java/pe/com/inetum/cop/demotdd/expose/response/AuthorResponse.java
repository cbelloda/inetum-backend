package pe.com.inetum.cop.demotdd.expose.response;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.inetum.cop.demotdd.model.Author;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponse {

  private String name;
  private String documento;
  private List<BookResponse> books;

  public static final  Function<Author, AuthorResponse> MAPPER = author -> AuthorResponse.builder()
      .name(author.getName())
      .documento(author.getDocumentNumber())
      .books(
          author.getAuthorBook().stream().map(authorBook -> authorBook.getBook())
              .map(book -> BookResponse.builder()
                  .description(book.getDescription())
                  .build())
              .collect(Collectors.toList()))
      .build();

}
