package pe.com.inetum.cop.msnecopconsulta.business;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.inetum.cop.msnecopconsulta.business.impl.NotificationServiceDefault;
import pe.com.inetum.cop.msnecopconsulta.expose.response.Notification;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitResult;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceDefaultTest {
  
  @Mock
  Sinks.Many<Notification> notificationSink;

@InjectMocks
NotificationServiceDefault notificationService;

@Test
void shouldsendAnEmitter(){
     

     when(notificationSink.tryEmitNext(any())).thenReturn(EmitResult.OK);

      notificationService.notify("a title", "adetail", "PREMIUM");

      verify(notificationSink,times(1)).tryEmitNext(any());
     
}

}
