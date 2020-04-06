public class HiddenOctahedronFractalRotate extends ObjectRotate {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java HiddenOctahedronFractalRotate #iteration");
        else
        (new HiddenOctahedronFractalRotate("HiddenOctahedronFractalRotate", Integer.parseInt(args[0]))).showFrame();
    }

    protected HiddenOctahedronFractalRotate(String name, int times) {
        super(name);
        object = new HiddenOctahedronFractal(times);
    }
}