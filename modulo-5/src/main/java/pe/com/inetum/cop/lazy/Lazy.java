package pe.com.inetum.cop.lazy;

import java.util.function.Supplier;
import lombok.Builder;

@Builder
public class Lazy<T> {

  private T instance;
  private Supplier<T> supplier;

  public T get(){
    if(instance ==null){
      instance = supplier.get();
      supplier = null;
    }
    return instance;
  }
  
}
