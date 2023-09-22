package pe.com.inetum.cop.module.funcional;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Person {

  int age;
  String name;
  Category category;

  
  
}
