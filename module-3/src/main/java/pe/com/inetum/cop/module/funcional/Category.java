package pe.com.inetum.cop.module.funcional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.inetum.cop.module.strategy.PriceStrategy;

@Getter
@AllArgsConstructor
public enum Category {
  PREMIUM( age -> age*100 + Math.PI), 
  REGULAR(age -> age*10 + Math.PI), 
  BASIC(age -> age*1 + Math.PI);

  PriceStrategy  strategy;
}
