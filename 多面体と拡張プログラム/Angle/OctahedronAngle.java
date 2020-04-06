public class OctahedronAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4) 
      (new OctahedronAngle("OctahedronAngle", args, 0)).showFrame();
    else                                     
      (new OctahedronAngle("OctahedronAngle")).showFrame();
  }

  protected OctahedronAngle(String name) {          
    super(name);                             
    object = new Octahedron();                      
  }

  protected OctahedronAngle(String name, String[] args, int offset) {
    super(name, args, offset);                
    object = new Octahedron();                     
  }
}
