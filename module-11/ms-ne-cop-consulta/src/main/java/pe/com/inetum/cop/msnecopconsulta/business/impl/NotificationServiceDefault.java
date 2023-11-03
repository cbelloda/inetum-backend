package pe.com.inetum.cop.msnecopconsulta.business.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.inetum.cop.msnecopconsulta.business.NotificationService;
import pe.com.inetum.cop.msnecopconsulta.business.TypeUser;
import pe.com.inetum.cop.msnecopconsulta.expose.response.Notification;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class NotificationServiceDefault implements NotificationService{

  private final Sinks.Many<Notification> notificationSink;

  @Override
  public void notify(String title, String detail, String typeUser) {

      Notification notification = Notification.builder()
              .title(title)
              .detail(detail)
              .typeUser(TypeUser.valueOf(typeUser))
              .build();


System.out.println("Enviando notificacion");
      notificationSink.tryEmitNext(notification);

  }
  
}
