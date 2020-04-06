public class SphereShade extends ObjectShade {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: SphereShade #iteration");
        }
        else {
            (new SphereShade("SphereShade", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected SphereShade(String name, int times) {
        super(name);
        object = new ShadingSphere(times);
    }
}