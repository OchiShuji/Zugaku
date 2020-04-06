public class DodecahedronAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4) 
      (new DodecahedronAngle("DodecahedronAngle", args, 0)).showFrame();
    else                                     
      (new DodecahedronAngle("DodecahedronAngle")).showFrame();
  }

  protected DodecahedronAngle(String name) {          
    super(name);                             
    object = new Dodecahedron();                      
  }

  protected DodecahedronAngle(String name, String[] args, int offset) {
    super(name, args, offset);                
    object = new Dodecahedron();                     
  }
}
