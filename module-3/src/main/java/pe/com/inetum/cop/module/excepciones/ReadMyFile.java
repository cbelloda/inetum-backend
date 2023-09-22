package pe.com.inetum.cop.module.excepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import lombok.extern.java.Log;

@Log
public class ReadMyFile {

  public void read(String filePath) throws IOException{

    File file = new File(filePath);  

    BufferedReader buffer = new BufferedReader(new FileReader(file));
    log.info(buffer.readLine());
    



  }
  
}
