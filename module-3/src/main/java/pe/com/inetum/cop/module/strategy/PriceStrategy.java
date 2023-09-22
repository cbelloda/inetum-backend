package pe.com.inetum.cop.module.strategy;

@FunctionalInterface
public interface PriceStrategy {
  
    Double calculate(Integer age);

}
