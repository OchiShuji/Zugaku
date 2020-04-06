public class OctahedronFractalAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: OctahedronFractalAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new OctahedronFractalAngle("OctahedronFractalAngle", args, 1)).showFrame();
            }
            else {
                (new OctahedronFractalAngle("OctahedronFractalAngle")).showFrame();
            }
        }
    }

    protected OctahedronFractalAngle(String name) {
        super(name);
        object = new OctahedronFractal(times);
    }

    protected OctahedronFractalAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new OctahedronFractal(times);
    }
}