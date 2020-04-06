public class SierpinskiSpin extends ObjectSpin {
    public static void main(String[] args) {
        if (args.length == 0) 
            System.err.println("Usage: java SierpinskiSpin #iteration");
        else 
            (new SierpinskiSpin("Sierpinski Spin", Integer.parseInt(args[0]))).showFrame();
    }

    protected SierpinskiSpin(String name, int times) {
        super(name);
        object = new Sierpinski(times);
    }
}