public class SierpinskiAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: SierpinskiAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new SierpinskiAngle("SierpinskiAngle", args, 1)).showFrame();
            }
            else {
                (new SierpinskiAngle("SierpinskiAngle")).showFrame();
            }
        }
    }

    protected SierpinskiAngle(String name) {
        super(name);
        object = new Sierpinski(times);
    }

    protected SierpinskiAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new Sierpinski(times);
    }
}