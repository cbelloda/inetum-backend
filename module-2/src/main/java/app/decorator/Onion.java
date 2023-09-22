package app.decorator;

public class Onion  extends IngredientsDecorator{

  public Onion(Pizza pizza) {
    super(pizza);    
  }

  @Override
  public String prepare(){
    return super.prepare() + " Con cebolla ";
  }
  
}
