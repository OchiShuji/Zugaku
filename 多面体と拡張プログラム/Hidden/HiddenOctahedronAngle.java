public class HiddenOctahedronAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4)   
      (new HiddenOctahedronAngle("HiddenOctahedronAngle", args, 0)).showFrame();
    else                                     
      (new HiddenOctahedronAngle("HiddenOctahedronAngle")).showFrame();
  }

  protected HiddenOctahedronAngle(String name) {         
    super(name);                              
    object = new HiddenOctahedron();                      
  }

  protected HiddenOctahedronAngle(String name, String[] args, int offset) {
    super(name, args, offset);              
    object = new HiddenOctahedron();                      
  }
}