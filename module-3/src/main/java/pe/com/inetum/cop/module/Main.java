package pe.com.inetum.cop.module;

import java.io.IOException;
import lombok.extern.java.Log;
import pe.com.inetum.cop.module.funcional.Category;
import pe.com.inetum.cop.module.funcional.MyFunctions;
import pe.com.inetum.cop.module.funcional.MyInterface;
import pe.com.inetum.cop.module.funcional.Person;
import pe.com.inetum.cop.module.optional.MyOptional;

@Log
public class Main {


  public static void main(String[] args) throws IOException{
   log.info("Hola module 4");

   //MyFunctions.execute();
   
   // MyInterface  forPremium =  s -> s.length() + 200d;

   // log.info("El valor de premium es "  +  forPremium.addElement("Carlos Belloda"));


//   MyFunctional.execute();

     //ExceptionApp.execute();




     MyOptional.execute();

  }
}
