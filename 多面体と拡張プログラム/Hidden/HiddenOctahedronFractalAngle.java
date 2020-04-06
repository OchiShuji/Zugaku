public class HiddenOctahedronFractalAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: HiddenOctahedronFractalAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new HiddenOctahedronFractalAngle("HiddenOctahedronFractalAngle", args, 1)).showFrame();
            }
            else {
                (new HiddenOctahedronFractalAngle("HiddenOctahedronFractalAngle")).showFrame();
            }
        }
    }

    protected HiddenOctahedronFractalAngle(String name) {
        super(name);
        object = new HiddenOctahedronFractal(times);
    }

    protected HiddenOctahedronFractalAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new HiddenOctahedronFractal(times);
    }
}