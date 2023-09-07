package builderpattern;

public class Main {
  public static void main(String[] args) {

    Person person = new Person.Builder()
    .address("mi casa")
    .name("mi nombre")
    .age(100)
    .build();

    System.out.println(person);
    
  }
}
