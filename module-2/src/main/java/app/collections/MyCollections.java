package app.collections;

import app.model.Person;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static app.Main.*;

public class MyCollections {

  public static void execute() {

    Person person1 = Person.builder()
        .name("Carlos")
        .lastname("Belloda")
        .age(10)
        .build();

    Person person2 = Person.builder()
        .name("Carlos")
        .lastname("Belloda")
        .age(5)
        .build();

    Person person3 = Person.builder()
        .name("Carlos")
        .lastname("Belloda")
        .age(20)
        .build();


    List<Person> people = new ArrayList<>();

    people.add(person1);
    people.add(person1);
    people.add(person2);
    people.add(person3);

    print(people.toString());


    print("Las personas son las mismas "+person1.equals(person2));


    Set<Person> setPerson = new HashSet();

setPerson.add(person1);
setPerson.add(person1);
setPerson.add(person1);
setPerson.add(person2);
setPerson.add(person3);

    print(setPerson.toString());

Set<Person> setPerson2 =  new TreeSet<>();
setPerson2.add(person1);
setPerson2.add(person2);
setPerson2.add(person3);

print(setPerson2.toString());


  }

}
