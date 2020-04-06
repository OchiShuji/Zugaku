public class SubdivisionShade extends ObjectShade {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: SubdivisionShade #iteration");
        }
        else {
            (new SubdivisionShade("SubdivisionShade", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected SubdivisionShade(String name, int times) {
        super(name);
        object = new ShadingSubdivision(times);
    }
}