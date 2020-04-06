import java.awt.*;

public class ColorRingHSB extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java ColorRingHSB #");
        else
          new ColorRingHSB("ColorRingHSB", Integer.parseInt(args[0]));
    }

    protected Color[] colors;
    private int num;

    protected ColorRingHSB(String name, int numberOfPoints) {
        super(name, numberOfPoints);
        setBackground(Color.black);
        setColor(numberOfPoints);    
    }

    protected void setColor(int numberOfPoints) {
        num = numberOfPoints;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < points.length; i++) {
            int j = (i+2) % points.length;
            float ratio = (float)i / num;
            g.setColor(Color.getHSBColor(ratio,1,1));
            g.drawLine(points[i][0], points[i][1], points[j][0], points[j][1]);
        }
    }
}