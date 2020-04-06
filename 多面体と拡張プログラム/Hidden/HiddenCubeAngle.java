public class HiddenCubeAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4)   
      (new HiddenCubeAngle("HiddenCubeAngle", args, 0)).showFrame();
    else                                     
      (new HiddenCubeAngle("HiddenCubeAngle")).showFrame();
  }

  protected HiddenCubeAngle(String name) {         
    super(name);                              
    object = new HiddenCube();                      
  }

  protected HiddenCubeAngle(String name, String[] args, int offset) {
    super(name, args, offset);              
    object = new HiddenCube();                      
  }
}