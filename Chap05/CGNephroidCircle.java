import java.awt.*;

public class CGNephroidCircle extends CGCircle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java CGNephroidCircle #");
        else {
          radius = 0.5;
          (new CGNephroidCircle("CGNephroidCircle", Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected CGNephroidCircle(String name, int numberOfPoints) {
        super(name, numberOfPoints);
        setOrigin(360, 350);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            int j = points.length - i - 1; 
            drawCircle(g, points[i], points[i].subtract(points[j]).norm()/2);
        }
    }
}