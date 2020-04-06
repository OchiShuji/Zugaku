import java.awt.*;

public class Nephroid extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java Nephroid #");
        else
          new Nephroid("Nephroid", Integer.parseInt(args[0]));
    }

    protected Nephroid(String name, int numberOfPoints) {
        super(name, numberOfPoints);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            int j = (3*i)%points.length;
            g.drawLine(points[i][0],points[i][1],points[j][0],points[j][1]);
        }
    }
}