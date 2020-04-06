public class HiddenDodecahedronAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4)   
      (new HiddenDodecahedronAngle("HiddenDodecahedronAngle", args, 0)).showFrame();
    else                                     
      (new HiddenDodecahedronAngle("HiddenDodecahedronAngle")).showFrame();
  }

  protected HiddenDodecahedronAngle(String name) {         
    super(name);                              
    object = new HiddenDodecahedron();                      
  }

  protected HiddenDodecahedronAngle(String name, String[] args, int offset) {
    super(name, args, offset);              
    object = new HiddenDodecahedron();                      
  }
}