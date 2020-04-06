public class HiddenSierpinskiAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: HiddenSierpinskiAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new HiddenSierpinskiAngle("HiddenSierpinskiAngle", args, 1)).showFrame();
            }
            else {
                (new HiddenSierpinskiAngle("HiddenSierpinskiAngle")).showFrame();
            }
        }
    }

    protected HiddenSierpinskiAngle(String name) {
        super(name);
        object = new HiddenSierpinski(times);
    }

    protected HiddenSierpinskiAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new HiddenSierpinski(times);
    }
}