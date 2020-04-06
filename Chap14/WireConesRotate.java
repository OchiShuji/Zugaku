public class WireConesRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new WireConesRotate("WireConesRotate")).showFrame();
    }

    protected WireConesRotate(String name) {
        super(name);
        object = new WireCones();
    }
}