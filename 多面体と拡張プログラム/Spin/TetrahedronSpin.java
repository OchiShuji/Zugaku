public class TetrahedronSpin extends ObjectSpin {
    public static void main(String[] args) {
        (new TetrahedronSpin("Tetrahedron Spin")).showFrame();
    }

    protected TetrahedronSpin(String name) {
        super(name);
        object = new Tetrahedron();
    }
}