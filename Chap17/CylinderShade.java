public class CylinderShade extends ObjectShade {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: CylinderShade #number of point");
        }
        else {
            (new CylinderShade("CylinderShade", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected CylinderShade(String name, int num) {
        super(name);
        object = new ShadingCylinder(num);
    }
}