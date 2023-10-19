package pe.com.inetum.cop.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.inetum.cop.demo.repository.MyRepository;

@Service
@RequiredArgsConstructor
public class MyService {

  
  private final MyRepository myRepository;
  private final String name;

  public String aMethod(){

    return myRepository.toString() + name;
  }

  
  
}
