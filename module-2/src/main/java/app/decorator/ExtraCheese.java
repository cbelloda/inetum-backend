package app.decorator;

public class ExtraCheese extends IngredientsDecorator{

  public ExtraCheese(Pizza pizza) {
    super(pizza);    
  }

  @Override
  public String prepare(){
    return super.prepare() + " Extra Cheese ";
  }
  
}
