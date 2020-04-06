import java.awt.*;
import java.awt.event.*;


public class Asteroid extends Canvas {
    public static void main(String[] args) {
        if (args.length == 0)
        System.err.println("Usage: java Asteroid #");
        else
        new Asteroid("Asteroid", Integer.parseInt(args[0]));

    }

    private static final int width = 600;
    private static final int height = 600;
    protected static int centerX = 300;
    protected static int centerY = 299;
    protected static int radius = 250;
    protected static int oval;
    

    protected Asteroid(String name, int numberOfOval) {
        super();
        setSize(width, height);
        setBackground(Color.white);
        setForeground(Color.black);
        oval = numberOfOval;

        Frame f = new Frame(name);
        f.add(this);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < radius+1; i=i + oval) {
            g.drawOval(centerX-radius+i, centerY-i, 2*(radius-i), 2*i);
        }
    }
}