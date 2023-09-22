package app.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class IngredientsDecorator implements Pizza{

        private Pizza pizza;

        public String prepare(){
          return pizza.prepare();
        }
        
  
}
