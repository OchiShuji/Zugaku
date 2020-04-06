public class IcosahedronFractalShade extends ObjectShade {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: IcosahedronFractalShade #iteration");
        }
        else {
            (new IcosahedronFractalShade("IcosahedronFractalShade", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected IcosahedronFractalShade(String name, int times) {
        super(name);
        object = new ShadingIcosahedronFractal(times);
    }
}