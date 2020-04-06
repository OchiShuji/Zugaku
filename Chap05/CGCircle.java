import java.awt.*;

public class CGCircle extends CGCanvas {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java CGCircle #");
        else
          (new CGCircle("CGCircle", Integer.parseInt(args[0]))).showFrame();
    }

    public static double radius = 0.8 * 2;
    protected Vector2D[] points;
    double r;

    protected CGCircle(String name, int numberOfPoints) {
        super(name);
        r = 4.0;
        setRange(r);
        points = new Vector2D[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            double theta = 2.0 * Math.PI * i / numberOfPoints;
            points[i] = new Vector2D(radius*Math.cos(theta), radius*Math.sin(theta)); 
        }
    }

    public void paint(Graphics g) {
        drawPolygon(g, points);
        /*
        for (int i = 0; i < points.length; i++) {
            int j = (i+1) % points.length;
            drawLine(g, points[i], points[j]);
        }
        */
    }
}