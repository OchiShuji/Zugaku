public class HiddenConesRotate extends ObjectRotate {
    public static void main(String[] args) {
        (new HiddenConesRotate("HiddenConesRotate")).showFrame();
    }

    protected HiddenConesRotate(String name) {
        super(name);
        object = new HiddenCones();
    }
}