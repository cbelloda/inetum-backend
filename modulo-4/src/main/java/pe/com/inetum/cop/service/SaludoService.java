package pe.com.inetum.cop.service;

import pe.com.inetum.cop.repository.Customer;

public class SaludoService {


  public String saludoBasic(Customer customer){
      return "Hola " +customer.getName();
  }
  public String saludoRegular(Customer customer){
    return "Estimado " +customer.getName();

  }
  public String saludoPremium(Customer customer){
    return "Excelentisimo " +customer.getName();

  }


  public String eval(Customer customer ){
        return customer.getCategory().getCalculate().apply(this, customer);
  }
  
}
