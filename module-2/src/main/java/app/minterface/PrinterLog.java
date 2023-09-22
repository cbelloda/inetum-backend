package app.minterface;
import static app.Main.*;


public class PrinterLog implements MyFirstInterface{

  @Override
  public void printElement(String element) {

        print("Printer Log "+element);

  }

  @Override
  public String getElementPrint() {
    return "Es un Log";
  }
  
}
