public class OctahedronRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new OctahedronRotate("OctahedronRotate")).showFrame();
    }

    protected OctahedronRotate(String name) {
        super(name);
        object = new Octahedron();
    }
}