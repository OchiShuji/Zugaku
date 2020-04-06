public class CubeTranslate extends ObjectTranslate {
    public static void main(String[] args) {
        (new CubeTranslate("Cube Translate")).showFrame();
    }

    protected CubeTranslate(String name) {
        super(name);
        object = new Cube();
    }
}