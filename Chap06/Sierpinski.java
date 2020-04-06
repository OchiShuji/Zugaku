import java.awt.*;

public class Sierpinski extends Fractal {
    public static void main(String[] args) {
        if (args.length != 1)
          System.err.println("Usage: Sierpinski #iteration");
        else
          (new Sierpinski("Sierpinski", Integer.parseInt(args[0]))).showFrame();
    }

    protected Sierpinski(String name, int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(300, 84);
        setRange(2.4);

        initPoints = new Vector2D[3];
        initPoints[0] = new Vector2D(0.0, 0.0);
        initPoints[1] = new Vector2D(-1.0, -Math.sqrt(3.0));
        initPoints[2] = new Vector2D(1.0, -Math.sqrt(3.0));

        m = new Matrix2X2[3];
        v = new Vector2D[3];
        m[0] = Matrix2X2.scale(1.0 / 2.0);
        m[1] = Matrix2X2.scale(1.0 / 2.0);
        m[2] = Matrix2X2.scale(1.0 / 2.0);
        v[0] = initPoints[0];
        v[1] = m[0].apply(initPoints[1].add(v[0]));
        v[2] = m[0].apply(initPoints[2]).add(v[0]);
    }

    protected void drawObject(Graphics g, Vector2D[] points) {
        g.setColor(Color.lightGray);
        fillPolygon(g, points);
        g.setColor(Color.black);
        drawPolygon(g, points);
    }
}