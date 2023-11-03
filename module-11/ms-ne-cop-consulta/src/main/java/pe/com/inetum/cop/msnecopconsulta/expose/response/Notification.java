package pe.com.inetum.cop.msnecopconsulta.expose.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pe.com.inetum.cop.msnecopconsulta.business.TypeUser;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class Notification implements Serializable{

  private TypeUser typeUser;
  private String title;
  private String detail;
  
  
}
