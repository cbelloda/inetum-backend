package herencia;

public class Main {
  
  public static void main(String[] args) {
    //Person person = new Person("Carlos","mi casa","Belloda","998837473",10);


    //System.out.println(person);


    Student student = new Student("Carlos","mi casa","Belloda","998837473",10,CollegeCareer.BIOLOGY);

    Professor professor = new Professor("Carlos","mi casa","Belloda","998837473",100);

    System.out.println(student.greetings());
    System.out.println(professor.greetings());




  }
}
