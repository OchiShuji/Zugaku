public class HiddenTetrahedronAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4)   
      (new HiddenTetrahedronAngle("HiddenTetrahedronAngle", args, 0)).showFrame();
    else                                     
      (new HiddenTetrahedronAngle("HiddenTetrahedronAngle")).showFrame();
  }

  protected HiddenTetrahedronAngle(String name) {         
    super(name);                              
    object = new HiddenTetrahedron();                      
  }

  protected HiddenTetrahedronAngle(String name, String[] args, int offset) {
    super(name, args, offset);              
    object = new HiddenTetrahedron();                      
  }
}