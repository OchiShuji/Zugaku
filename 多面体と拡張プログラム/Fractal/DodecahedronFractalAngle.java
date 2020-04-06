public class DodecahedronFractalAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: DodecahedronFractalAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new DodecahedronFractalAngle("DodecahedronFractalAngle", args, 1)).showFrame();
            }
            else {
                (new DodecahedronFractalAngle("DodecahedronFractalAngle")).showFrame();
            }
        }
    }

    protected DodecahedronFractalAngle(String name) {
        super(name);
        object = new DodecahedronFractal(times);
    }

    protected DodecahedronFractalAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new DodecahedronFractal(times);
    }
}