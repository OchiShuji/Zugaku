public class HiddenCubeRotate2 extends ObjectRotate {
    public static void main(String[] args) {
        (new HiddenCubeRotate2("HiddenCubeRotate2")).showFrame();
    }

    protected HiddenCubeRotate2(String name) {
        super(name);
        object = new HiddenCube2();
    }
}