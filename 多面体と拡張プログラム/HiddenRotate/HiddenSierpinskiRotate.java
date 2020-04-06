public class HiddenSierpinskiRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java HiddenSierpinskiRotate #iteration");
        else
        (new HiddenSierpinskiRotate("HiddenSierpinskiRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected HiddenSierpinskiRotate(String name, int times) {
        super(name);
        object = new HiddenSierpinski(times);
    }
}