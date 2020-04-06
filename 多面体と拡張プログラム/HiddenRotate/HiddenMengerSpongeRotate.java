public class HiddenMengerSpongeRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java HiddenMengerSpongeRotate #iteration");
        else
        (new HiddenMengerSpongeRotate("HiddenMengerSpongeRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected HiddenMengerSpongeRotate(String name, int times) {
        super(name);
        object = new HiddenMengerSponge(times);
    }
}