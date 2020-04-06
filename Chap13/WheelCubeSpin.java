public class WheelCubeSpin extends WheelSpin {
    public static void main(String[] args) {
        (new WheelCubeSpin("Wheel Cube Spin")).showFrame();
    }

    protected WheelCubeSpin(String name) {
        super(name);
        object = new Cube();
    }
}