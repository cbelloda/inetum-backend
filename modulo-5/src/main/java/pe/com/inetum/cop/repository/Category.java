package pe.com.inetum.cop.repository;

import java.util.function.BiFunction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.inetum.cop.service.SaludoService;
import pe.com.inetum.cop.service.ServiceCustomer;

@AllArgsConstructor
@Getter
public enum Category {
  BASIC(SaludoService::saludoBasic),
  REGULAR(SaludoService::saludoRegular),
  PREMIUM(SaludoService::saludoPremium);

  private BiFunction<SaludoService,Customer,String>  calculate;
}
