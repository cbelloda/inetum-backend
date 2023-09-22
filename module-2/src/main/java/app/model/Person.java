package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Builder
@EqualsAndHashCode
public class Person implements Comparable<Person>{

  private String name;
  private String lastname;
  private int age;
  
  @Override
  public int compareTo(Person o) {

      return this.getAge() - o.getAge();
  }
  
}
