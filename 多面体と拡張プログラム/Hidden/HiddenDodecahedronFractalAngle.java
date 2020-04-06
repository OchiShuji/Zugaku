public class HiddenDodecahedronFractalAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: HiddenDodecahedronFractalAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new HiddenDodecahedronFractalAngle("HiddenDodecahedronFractalAngle", args, 1)).showFrame();
            }
            else {
                (new HiddenDodecahedronFractalAngle("HiddenDodecahedronFractalAngle")).showFrame();
            }
        }
    }

    protected HiddenDodecahedronFractalAngle(String name) {
        super(name);
        object = new HiddenDodecahedronFractal(times);
    }

    protected HiddenDodecahedronFractalAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new HiddenDodecahedronFractal(times);
    }
}