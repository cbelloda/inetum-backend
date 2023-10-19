package pe.com.inetum.cop.mailer;

import java.util.function.Consumer;
import lombok.extern.java.Log;

@Log
public class Mailer {

  //execute around method pattern

  public Mailer from(String from){
    log.info("aquí estoy en el método from"+from);
    return this;
  }
  public Mailer to(String to){
    log.info("aquí estoy en el método to"+to);
    return this;
  }
  public Mailer subject(String subject){
    log.info("aquí estoy en el método subject"+subject);
    return this;
  }
  public Mailer body(String body){
    log.info("aquí estoy en el método body"+body);
    return this;
  }
  public Mailer adjunt(String adjunt){
    log.info("aquí estoy en el método adjunt"+adjunt);
    return this;
  }

  public static void send(Consumer<Mailer> consumerMailer ){

    Mailer mail = new Mailer();
    
    consumerMailer.accept(mail);

    log.info("Enviamos el correo  --") ;
  }
  
}
