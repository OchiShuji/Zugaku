import java.awt.*;

public class Koch extends Fractal {
    public static void main(String[] args) {
        if (args.length != 1)
          System.err.println("Usage: Koch #iteration");
        else
          (new Koch("Koch", Integer.parseInt(args[0]))).showFrame();
    }

    protected Koch(String name, int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(50, 299);
        setRange(1.2);

        initPoints = new Vector2D[2];
        initPoints[0] = new Vector2D(0.0, 0.0);
        initPoints[1] = new Vector2D(1.0, 0.0);

        m = new Matrix2X2[4];
        v = new Vector2D[4];
        m[0] = Matrix2X2.scale(1.0 / 3.0);
        m[1] = Matrix2X2.rotate(Math.PI / 3.0).multiply(Matrix2X2.scale(1.0 / 3.0));
        m[2] = Matrix2X2.rotate(-Math.PI / 3.0).multiply(Matrix2X2.scale(1.0 / 3.0));
        m[3] = Matrix2X2.scale(1.0 / 3.0);
        v[0] = initPoints[0];
        v[1] = m[0].apply(initPoints[1]).add(v[0]);
        v[2] = m[1].apply(initPoints[1]).add(v[1]);
        v[3] = m[2].apply(initPoints[1]).add(v[2]);
    }

    protected void drawObject(Graphics g, Vector2D[] points) {
        drawPolyline(g, points);
    }
}