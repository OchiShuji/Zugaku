public class HiddenCubeRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new HiddenCubeRotate("HiddenCubeRotate")).showFrame();
    }

    protected HiddenCubeRotate(String name) {
        super(name);
        object = new HiddenCube();
    }
}