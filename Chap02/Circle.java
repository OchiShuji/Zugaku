import java.awt.*;
import java.awt.event.*;

public class Circle extends Canvas {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java Circle #");
        else
          new Circle("Circle", Integer.parseInt(args[0]));

    }

    private static final int width = 600;
    private static final int height = 600;
    protected static int centerX = 300;
    protected static int centerY = 299;
    protected static int radius = 250;
    protected int[][] points;

    protected Circle(String name, int numberOfPoints) {
        super();
        setSize(width, height);
        setBackground(Color.white);
        setForeground(Color.black);

        points = new int[numberOfPoints][];
        for (int i = 0; i < numberOfPoints; i++) {
          double theta = 2.0 * Math.PI * i / numberOfPoints;

          points[i] = new int[2];
          points[i][0] = (int)(radius * Math.cos(theta)) + centerX;
          points[i][1] = (int)(radius * Math.sin(theta)) + centerY;
        }
        
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
        for (int i = 0; i < points.length; i++) {
            int j = (i+1) % points.length;
            g.drawLine(points[i][0], points[i][1], points[j][0], points[j][1]);
        }
    }
}