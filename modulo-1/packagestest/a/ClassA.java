package packagestest.a;

import packagestest.b.ClassB;

public class ClassA {
  public static void main(String[] args) {
    //ClassB classB = new ClassB();

    //classB.getSaludo();
    ClassB.count = 10;




    //System.out.println("Suma de 100 + 10 =  " + classB.add(100,10));

    ClassB.addVoid(100,10);

    
  }
}
