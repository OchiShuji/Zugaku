import java.awt.*;

public class CardioidOval extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java CardioidOval #");
        else {
            centerX += 70;
            radius = 100;
            new CardioidOval("CardioidOval", Integer.parseInt(args[0]));
        }
    }

    protected CardioidOval(String name, int numberOfPoints) {
        super(name, numberOfPoints);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            double dx = points[i][0] - points[0][0];
            double dy = points[i][1] - points[0][1];
            int r = (int)Math.sqrt(dx*dx +dy*dy);
            g.drawOval(points[i][0] - r, points[i][1] -r, 2*r, 2*r);
        }
    }
}