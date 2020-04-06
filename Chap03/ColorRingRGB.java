import java.awt.*;

public class ColorRingRGB extends Circle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java ColorRingRGB #");
        else
          new ColorRingRGB("ColorRingRGB", Integer.parseInt(args[0]));
    }

    protected Color[] colors;

    protected ColorRingRGB(String name, int numberOfPoints) {
        super(name, numberOfPoints);
        setBackground(Color.black);
        setColor(numberOfPoints);    
    }

    protected void setColor(int numberOfPoints) {
        final float oneSixth = 1.0f / 6.0f;
        final float twoSixth = 2.0f / 6.0f;
        final float threeSixth = 3.0f / 6.0f;
        final float fourSixth = 4.0f / 6.0f;
        final float fiveSixth = 5.0f / 6.0f;
        final float six = 6.0f;

        colors = new Color[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            float ratio = (float)i / numberOfPoints;

            if (ratio <= oneSixth) {
                colors[i] = new Color(1.0f, ratio * six, 0.0f);
            } else if (ratio <= twoSixth) {
                colors[i] = new Color((twoSixth - ratio) * six, 1.0f, 0.0f);
            } else if (ratio <= threeSixth) {
                colors[i] = new Color(0.0f, 1.0f, (ratio - twoSixth) * six);
            } else if (ratio <= fourSixth) {
                colors[i] = new Color(0.0f, (fourSixth - ratio) * six, 1.0f);
            } else if (ratio <= fiveSixth) {
                colors[i] = new Color((ratio - fourSixth) * six, 0.0f, 1.0f);
            } else {
                colors[i] = new Color(1.0f, 0.0f, (1.0f - ratio) * six);
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < points.length; i++) {
            int j = (i+2) % points.length;
            g.setColor(colors[i]);
            g.drawLine(points[i][0], points[i][1], points[j][0], points[j][1]);
        }
    }
}