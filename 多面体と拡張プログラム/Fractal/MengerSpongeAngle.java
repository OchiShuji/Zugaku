public class MengerSpongeAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: MengerSpongeAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new MengerSpongeAngle("MengerSpongeAngle", args, 1)).showFrame();
            }
            else {
                (new MengerSpongeAngle("MengerSpongeAngle")).showFrame();
            }
        }
    }

    protected MengerSpongeAngle(String name) {
        super(name);
        object = new MengerSponge(times);
    }

    protected MengerSpongeAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new MengerSponge(times);
    }
}