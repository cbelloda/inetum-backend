package app.minterface;
import static app.Main.*;

public class PrinterFile  implements MyFirstInterface{

  @Override
  public void printElement(String element) {
    print("Printer File " + element);
  }

  @Override
  public String getElementPrint() {
    return "Printer File";
  }
  
}
