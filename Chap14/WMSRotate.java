public class WMSRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java WMSRotate #iteration");
        else
          (new WMSRotate("WMSRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected WMSRotate(String name, int times) {
        super(name);
        object = new WireMengerSponge(times);
    }
}