package pe.com.inetum.cop.module.funcional;

@FunctionalInterface
public interface MyInterface {

  static final double FACTOR = 100;

  Double getPrice(String name);  


  default Double addElement(String element){

    return getPrice(element) + 200*FACTOR;

  }


}



