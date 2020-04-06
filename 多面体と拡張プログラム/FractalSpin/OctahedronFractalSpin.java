public class OctahedronFractalSpin extends ObjectSpin {
    public static void main(String[] args) {
        if (args.length == 0) 
            System.err.println("Usage: java OctahedronFractalSpin #iteration");
        else 
            (new OctahedronFractalSpin("OctahedronFractalSpin", Integer.parseInt(args[0]))).showFrame();
    }

    protected OctahedronFractalSpin(String name, int times) {
        super(name);
        object = new OctahedronFractal(times);
    }
}