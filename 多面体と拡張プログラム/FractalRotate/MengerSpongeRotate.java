public class MengerSpongeRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java MengerSpongeRotate #iteration");
        else
        (new MengerSpongeRotate("MengerSpongeRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected MengerSpongeRotate(String name, int times) {
        super(name);
        object = new MengerSponge(times);
    }
}