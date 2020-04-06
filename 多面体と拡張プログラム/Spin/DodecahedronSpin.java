public class DodecahedronSpin extends ObjectSpin {
    public static void main(String[] args) {
        (new DodecahedronSpin("Dodecahedron Spin")).showFrame();
    }

    protected DodecahedronSpin(String name) {
        super(name);
        object = new Dodecahedron();
    }
}