public class SierpinskiRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java SierpinskiRotate #iteration");
        else
        (new SierpinskiRotate("SierpinskiRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected SierpinskiRotate(String name, int times) {
        super(name);
        object = new Sierpinski(times);
    }
}