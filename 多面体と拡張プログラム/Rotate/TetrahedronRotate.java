public class TetrahedronRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new TetrahedronRotate("TetrahedronRotate")).showFrame();
    }

    protected TetrahedronRotate(String name) {
        super(name);
        object = new Tetrahedron();
    }
}