package herencia;

public class Professor extends Person{
 

  public Professor(String name,String address,String lastname,String phone,Integer age){
    super(name, address, lastname, phone, age);   

  }

  @Override
  protected String greetings() {
    
    return "EL saludo del profesor";
  }
  
}
