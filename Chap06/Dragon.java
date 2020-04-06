import java.awt.*;

public class Dragon extends Fractal {
    public static void main(String[] args) {
        if (args.length != 1)
          System.err.println("Usage: Dragon #iteration");
        else
          (new Dragon("Dragon", Integer.parseInt(args[0]))).showFrame();
    }

    protected Dragon(String name, int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(150, 350);
        setRange(2.0);

        initPoints = new Vector2D[2];
        initPoints[0] = new Vector2D(0.0, 0.0);
        initPoints[1] = new Vector2D(1.0, 0.0);

        m = new Matrix2X2[2];
        v = new Vector2D[2];
        m[0] = Matrix2X2.scale(1.0 / Math.sqrt(2.0)).multiply(Matrix2X2.rotate(Math.PI / 4));
        m[1] = Matrix2X2.scale(1.0 / Math.sqrt(2.0)).multiply(Matrix2X2.rotate(3 * Math.PI / 4));
        v[0] = initPoints[0];
        v[1] = m[0].apply(initPoints[1]).subtract(m[1].apply(initPoints[1]));
    }

    protected void drawObject(Graphics g, Vector2D[] points) {
        drawPolyline(g, points);
    }
}