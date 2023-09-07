package structcontrol;

public class Main {

  String name;

  DAYWEEK day;

  enum DAYWEEK{
      LUNES ,MARTES,MIERCOLES,JUEVES
  }

  public static void main(String[] args) {
    
      int number1 = 100;
      int number2 = 200;

      if(number1<100){
          System.out.println("el numero "+number1+" es menor a 100");
      }else{
          System.out.println("el numero "+number1+" es mayor igual a 100");
      }

      System.out.println("el numero "+number1+" es " + (number1<100?"menor":"mayor igual ") +  " a 100");
      for(int i=0; i<100;i++){
        System.out.println("numero " + i);
      }
      int ind = 0;

      while(ind < 100){
        System.out.println("el indice "+ind);
        if(ind==50){
          System.out.println("salimos en el indice 50");
          continue;
        }
        ind++;
      }


  }
  
}
