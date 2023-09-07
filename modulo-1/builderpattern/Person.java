package builderpattern;


public class Person {

  private final String name;
  private final String address;
  private final String lastname;
  private final String phone;
  private final Integer age;

  public static class Builder {
    private String name = "";
    private String address = "";
    private String lastname = "";
    private String phone = "00000";
    private Integer age = 10;

    public Builder() {

    }

    public Builder name(String val) {
      name = val;
      return this;
    }

    public Builder address(String val) {
      address = val;
      return this;
    }

    public Builder lastname(String val) {
      lastname = val;
      return this;
    }

    public Builder phone(String val) {
      phone = val;
      return this;
    }

    public Builder age(Integer val) {
      age = val;
      return this;
    }

    public Person build() {
      return new Person(this);
    }

  }

  public Person(Builder build) {
    name = build.name;
    address = build.address;
    lastname = build.lastname;
    phone = build.phone;
    age = build.age;
  }

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
  public String toString() {
    return "La persona " + name;
  }

}
