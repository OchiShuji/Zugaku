import java.awt.*;

public class DiamondPattern extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java DiamondPattern #");
        else
          new DiamondPattern("DiamondPattern", Integer.parseInt(args[0]));
    }

    protected DiamondPattern(String name, int numberOfPoints) {
        super(name, numberOfPoints);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            for (int k = 0; k < points.length; k++) {
                int j = (k*i) % points.length;
                g.drawLine(points[i][0],points[i][1],points[j][0],points[j][1]);
            }
        }
    }
}