import java.awt.*;

public abstract class Fractal extends CGCanvas {
    protected int times;
    protected Vector2D[] initPoints;
    protected Matrix2X2[] m;
    protected Vector2D[] v;

    protected Fractal(String name, int times) {
        super(name);
        this.times = times;
        setData();
    }

    protected abstract void setData();

    public void paint(Graphics g) {
        drawObject(g, initPoints, times);
    }

    protected void drawObject(Graphics g, Vector2D[] points, int l) {
        if (l > 0) {
            for (int i = 0; i < m.length; i++) {
                Vector2D[] newPoints = new Vector2D[points.length];
                for (int j = 0; j < points.length; j++) {
                    newPoints[j] = m[i].apply(points[j]).add(v[i]);
                }
                drawObject(g, newPoints, l-1);
            }
        }
        else {
            drawObject(g, points);
        }
    }
    
    protected abstract void drawObject(Graphics g, Vector2D[] points);
}