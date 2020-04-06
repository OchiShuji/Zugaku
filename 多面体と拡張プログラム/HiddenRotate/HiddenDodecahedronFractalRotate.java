public class HiddenDodecahedronFractalRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java HiddenDodecahedronFractalRotate #iteration");
        else
        (new HiddenDodecahedronFractalRotate("HiddenDodecahedronFractalRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected HiddenDodecahedronFractalRotate(String name, int times) {
        super(name);
        object = new HiddenDodecahedronFractal(times);
    }
}