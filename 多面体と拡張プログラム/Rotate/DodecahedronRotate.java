public class DodecahedronRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new DodecahedronRotate("DodecahedronRotate")).showFrame();
    }

    protected DodecahedronRotate(String name) {
        super(name);
        object = new Dodecahedron();
    }
}