package app.decorator;
import static app.Main.*;

public class MyDecorator {

  public static void execute(){
    Pizza pizza = new Onion(new ExtraCheese(new PizzaBasic()));
    Pizza pizza1 = new ExtraCheese(new ExtraCheese(new PizzaBasic()));
    Pizza pizza2 = new Onion(new PizzaHawaiana());
    Pizza pizza3 = new PizzaBasic();
      print(pizza.prepare());
      print(pizza1.prepare());
      print(pizza2.prepare());
      print(pizza3.prepare());


    
  }
  
}
