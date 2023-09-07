package herencia;

public class Student extends Person{

   private CollegeCareer career;

  public Student(String name,String address,String lastname,String phone,Integer age,CollegeCareer career){
    super(name, address, lastname, phone, age);
    this.career= career;

  }

public CollegeCareer getCareer() {
  return career;
}

@Override
protected String greetings() {
  return "El saludo del alumno";
}


  
}
