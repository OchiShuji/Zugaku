public class DodecahedronFractalSpin extends ObjectSpin {
    public static void main(String[] args) {
        if (args.length == 0) 
            System.err.println("Usage: java DodecahedronFractalSpin #iteration");
        else 
            (new DodecahedronFractalSpin("DodecahedronFractalSpin", Integer.parseInt(args[0]))).showFrame();
    }

    protected DodecahedronFractalSpin(String name, int times) {
        super(name);
        object = new DodecahedronFractal(times);
    }
}