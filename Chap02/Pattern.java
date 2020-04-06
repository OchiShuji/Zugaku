import java.awt.*;

public class Pattern extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java Pattern #");
        else
          new Pattern("Pattern", Integer.parseInt(args[0]));
    }

    protected Pattern(String name, int numberOfPoints) {
        super(name, numberOfPoints);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < points.length; i++) {
            int j = (4*i)%points.length;
            g.drawLine(points[i][0],points[i][1],points[j][0],points[j][1]);
        }
    }
}