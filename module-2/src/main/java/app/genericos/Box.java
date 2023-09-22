package app.genericos;

public class Box <T,U>{

  T pair;
  U key;

  public Box(T pair , U key){
      this.pair=pair;
      this.key = key;
  }

  T getElement(){
      return pair;
  }
}
