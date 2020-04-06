public class CubeSpin extends ObjectSpin {
    public static void main(String[] args) {
        (new CubeSpin("Cube Spin")).showFrame();
    }

    protected CubeSpin(String name) {
        super(name);
        object = new Cube();
    }
}