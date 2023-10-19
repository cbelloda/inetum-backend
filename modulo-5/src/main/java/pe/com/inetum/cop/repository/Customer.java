package pe.com.inetum.cop.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Customer {
  
  Long id;
  String name;
  Category category;
  Integer age;
  
}
