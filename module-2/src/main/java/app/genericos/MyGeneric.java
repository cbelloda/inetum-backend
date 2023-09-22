package app.genericos;
import static app.Main.*;

public class MyGeneric {

  public static <T extends Number> void printNumber(T element){
      print("EL elemento " + element);
  } 

  public static void execute(){
    Box<String,String> boxString = new Box<>("","");
    Box<Integer,String> boxInteger = new Box<>(100,"Hola");

    boxString.getElement();

    printNumber(boxInteger.getElement());

  }
  
}
