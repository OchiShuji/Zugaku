import java.awt.*;

public class CGCardioidCircle extends CGCircle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java CGCardioidCircle #");
        else {
          radius = 0.3;
          (new CGCardioidCircle("CGCardioidCircle", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected CGCardioidCircle(String name, int numberOfPoints) {
        super(name, numberOfPoints);
        setOrigin(360, 299);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            drawCircle(g, points[i], points[i].subtract(points[0]).norm());
        }
    }
}