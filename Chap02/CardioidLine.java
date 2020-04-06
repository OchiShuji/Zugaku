import java.awt.*;

public class CardioidLine extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java CardioidLine #");
        else
          new CardioidLine("CardioidLine", Integer.parseInt(args[0]));
    }

    protected CardioidLine(String name, int numberOfPoints) {
        super(name, numberOfPoints);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            int j = (2*i)%points.length;
            g.drawLine(points[i][0],points[i][1],points[j][0],points[j][1]);
        }
    }
}