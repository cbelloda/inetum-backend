package app.minterface;

public class MyInterface {

  public static void printer(MyFirstInterface printerInterface){

    printerInterface.printElement(" mi elemento ");
  }

  public static void execute(){

    PrinterFile printerFile = new PrinterFile();
    PrinterLog printerLog = new PrinterLog();

    printer(printerFile);
    printer(printerLog);

   // printerFile.printElement(" mi elemento ");
   // printerLog.printElement(" mi elemento ");
  }
  
}
