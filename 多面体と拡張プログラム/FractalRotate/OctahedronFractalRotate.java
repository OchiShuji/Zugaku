public class OctahedronFractalRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java OctahedronFractalRotate #iteration");
        else
        (new OctahedronFractalRotate("OctahedronFractalRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected OctahedronFractalRotate(String name, int times) {
        super(name);
        object = new OctahedronFractal(times);
    }
}