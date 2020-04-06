public class CubeTranslate2 extends ObjectTranslate2 {
    public static void main(String[] args) {
        (new CubeTranslate2("Cube Translate 2")).showFrame();
    }

    protected CubeTranslate2(String name) {
        super(name);
        object = new Cube();
    }
}