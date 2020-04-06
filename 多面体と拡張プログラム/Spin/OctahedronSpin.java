public class OctahedronSpin extends ObjectSpin {
    public static void main(String[] args) {
        (new OctahedronSpin("Octahedron Spin")).showFrame();
    }

    protected OctahedronSpin(String name) {
        super(name);
        object = new Octahedron();
    }
}