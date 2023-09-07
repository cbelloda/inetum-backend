package herencia;

public abstract class Person {

  private String name ;  
  private String address;
  private String lastname;
  private String phone;
  private Integer age;  

  public Person(String name,String address,String lastname,String phone,Integer age){
        this.name=name;
        this.address=address;
        this.lastname=lastname;
        this.phone=phone;
        this.age= age;
  }

  protected abstract String greetings();
  
  public String getAddress() {
    return address;
  }

  public Integer getAge() {
    return age;
  }

  public String getLastname() {
    return lastname;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }
  
  @Override
  public String toString(){
        return "La persona "+name;
  }
  
}
