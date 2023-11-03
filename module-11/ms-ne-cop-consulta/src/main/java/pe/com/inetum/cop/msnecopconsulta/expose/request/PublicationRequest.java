package pe.com.inetum.cop.msnecopconsulta.expose.request;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicationRequest {

  @NotNull
  private String title;
  private String description;
  
  
}
