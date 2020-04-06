public class MengerSpongeShade extends ObjectShade {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: MengerSpongeShade #iteration");
        }
        else {
            (new MengerSpongeShade("MengerSpongeShade", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected MengerSpongeShade(String name, int times) {
        super(name);
        object = new ShadingMengerSponge(times);
    }
}