package packagestest.b;

public class ClassB {

  private String saludo ="Hola Mundodesde B";

  public static int count ;

  public Integer add (int x, int y){
    return x+y;
  }

  public static void addVoid (int x, int y){
    System.out.println("suma de elementos " + (x+y));
  }

  public String getSaludo() {
    return saludo;
  }

  
}
