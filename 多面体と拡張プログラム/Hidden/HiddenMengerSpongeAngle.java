public class HiddenMengerSpongeAngle extends ObjectAngle {
    static int times = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: HiddenMengerSpongeAngle #iteration[ ... ]");
        }
        else {
            times = Integer.parseInt(args[0]);
            if (args.length > 1 && args.length < 5) {
                (new HiddenMengerSpongeAngle("HiddenMengerSpongeAngle", args, 1)).showFrame();
            }
            else {
                (new HiddenMengerSpongeAngle("HiddenMengerSpongeAngle")).showFrame();
            }
        }
    }

    protected HiddenMengerSpongeAngle(String name) {
        super(name);
        object = new HiddenMengerSponge(times);
    }

    protected HiddenMengerSpongeAngle(String name, String[] args, int offset) {
        super(name, args, offset);
        object = new HiddenMengerSpongej(times);
    }
}