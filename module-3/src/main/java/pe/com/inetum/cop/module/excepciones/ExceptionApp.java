package pe.com.inetum.cop.module.excepciones;

import java.io.IOException;
import lombok.extern.java.Log;

@Log
public class ExceptionApp {




  public double division(int a, int b){
      if(b==0){
        throw new ArithmeticException("");
      }
      return (double) a/b;
  }

  public int getSomething(int a ){

    try{
    String n = null;
    if(a == 20){
        n="casa";
    }
    int anotherNumber = n.length();

    return Integer.parseInt(n);
  }catch(NumberFormatException  e){
        log.info("uppss fue un number ");
        return -1;
  }catch(NullPointerException e ){
        log.info("uppss fue un null");
        return -2;
  }finally{
    log.info("aquí va el finally");
    return -3;
  }

  }



  public int getInteger(String number){

    try{
    return  Integer.parseInt(number);
    }catch(NumberFormatException e){
      log.info("No hemos podido convertir " + number +" en un número");
      return 0;
    }   

  }


  public static void execute() throws IOException{
    ExceptionApp exceptionApp = new ExceptionApp();

    int mynumber = exceptionApp.getInteger("asa");

    log.info("el numero es "+mynumber);


    exceptionApp.division(100,1);

            log.info("el numero es "+exceptionApp.getSomething(100));
            

    new ReadMyFile().read("holssa.txt");


  }
  
}
