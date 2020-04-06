public class CubeRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new CubeRotate("CubeRotate")).showFrame();
    }

    protected CubeRotate(String name) {
        super(name);
        object = new Cube();
    }
}