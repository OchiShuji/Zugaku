public class DumpingCubeSpin extends DumpingSpin {
    public static void main(String[] args) {
        (new DumpingCubeSpin("Dumping Cube Spin")).showFrame();
    }

    protected DumpingCubeSpin(String name) {
        super(name);
        object = new Cube();
    }
}