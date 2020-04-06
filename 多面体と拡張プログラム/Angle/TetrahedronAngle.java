public class TetrahedronAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4) 
      (new TetrahedronAngle("TetrahedronAngle", args, 0)).showFrame();
    else                                     
      (new TetrahedronAngle("TetrahedronAngle")).showFrame();
  }

  protected TetrahedronAngle(String name) {          
    super(name);                             
    object = new Tetrahedron();                      
  }

  protected TetrahedronAngle(String name, String[] args, int offset) {
    super(name, args, offset);                
    object = new Tetrahedron();                     
  }
}
