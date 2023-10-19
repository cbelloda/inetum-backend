package pe.com.inetum.cop.service;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pe.com.inetum.cop.repository.Category;

@Getter
@Builder
@ToString
public class Response {

  private String name;
  private String saludo;
  private Map<Category,Long> accounts; ///  agrupar por categorias al resto de clientes y vamos a sumar;
  
}
