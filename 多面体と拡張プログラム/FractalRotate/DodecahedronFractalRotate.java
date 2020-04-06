public class DodecahedronFractalRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java DodecahedronFractalRotate #iteration");
        else
        (new DodecahedronFractalRotate("DodecahedronFractalRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected DodecahedronFractalRotate(String name, int times) {
        super(name);
        object = new DodecahedronFractal(times);
    }
}