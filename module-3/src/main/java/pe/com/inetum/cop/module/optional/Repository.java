package pe.com.inetum.cop.module.optional;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import pe.com.inetum.cop.module.funcional.Category;
import pe.com.inetum.cop.module.funcional.Person;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Repository {

  public static Person getAPerson(){

      return Person.builder()
      .age(10)
      .category(Category.PREMIUM)
      .build();

  }

  public static List<Person> getAllPerson(){
    Person person1 = Person.builder()
        .age(50)
        .name("Carlos")
        .category(Category.PREMIUM)
        .build();

     Person person2 = Person.builder()
        .age(20)
        .name("Enrique")
        .category(Category.BASIC)
        .build();   

         Person person3 = Person.builder()
        .age(30)
        .name("Belloda")
        .category(Category.PREMIUM)
        .build();   

         Person person4 = Person.builder()
        .age(90)
        .name("Saavedra")
        .category(Category.REGULAR)
        .build();   


return List.of(person1,person2,person3,person4);
  
  }
  
}
