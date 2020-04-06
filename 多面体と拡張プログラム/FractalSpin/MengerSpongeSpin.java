public class MengerSpongeSpin extends ObjectSpin {
    public static void main(String[] args) {
        if (args.length == 0) 
            System.err.println("Usage: java MengerSpongeSpin #iteration");
        else 
            (new MengerSpongeSpin("MengerSpongeSpin", Integer.parseInt(args[0]))).showFrame();
    }

    protected MengerSpongeSpin(String name, int times) {
        super(name);
        object = new MengerSponge(times);
    }
}