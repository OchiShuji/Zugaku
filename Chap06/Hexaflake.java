import java.awt.*;

public class Hexaflake extends Fractal {
    public static void main(String[] args) {
        if (args.length != 1) 
          System.err.println("Usage: java Hexaflake #iteration");
        else
          (new Hexaflake("Hexaflakes", Integer.parseInt(args[0]))).showFrame();
    }

    protected Hexaflake(String name, int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(300, 299);
        setRange(2.5);

        initPoints = new Vector2D[6];
        initPoints[0] = new Vector2D(Math.cos(Math.PI / 6), Math.sin(Math.PI / 6));
        initPoints[1] = new Vector2D(Math.cos(Math.PI / 2), Math.sin(Math.PI / 2));
        initPoints[2] = new Vector2D(Math.cos(5 * Math.PI / 6), Math.sin(5 * Math.PI / 6));
        initPoints[3] = new Vector2D(Math.cos(7 * Math.PI / 6), Math.sin(7 * Math.PI / 6));
        initPoints[4] = new Vector2D(Math.cos(3 * Math.PI / 2), Math.sin(3 * Math.PI / 2));
        initPoints[5] = new Vector2D(Math.cos(11 * Math.PI / 6), Math.sin(11 * Math.PI / 6));

        m = new Matrix2X2[7];
        v = new Vector2D[7];
        m[0] = Matrix2X2.scale(1.0 / 3.0);
        m[1] = Matrix2X2.scale(1.0 / 3.0);
        m[2] = Matrix2X2.scale(1.0 / 3.0);
        m[3] = Matrix2X2.scale(1.0 / 3.0);
        m[4] = Matrix2X2.scale(1.0 / 3.0);
        m[5] = Matrix2X2.scale(1.0 / 3.0);
        m[6] = Matrix2X2.scale(1.0 / 3.0);
        v[0] = m[0].multiply(Matrix2X2.scale(2.0)).apply(initPoints[0]);
        v[1] = m[1].multiply(Matrix2X2.scale(2.0)).apply(initPoints[1]);
        v[2] = m[2].multiply(Matrix2X2.scale(2.0)).apply(initPoints[2]);
        v[3] = m[3].multiply(Matrix2X2.scale(2.0)).apply(initPoints[3]);
        v[4] = m[4].multiply(Matrix2X2.scale(2.0)).apply(initPoints[4]);
        v[5] = m[5].multiply(Matrix2X2.scale(2.0)).apply(initPoints[5]);
        v[6] = new Vector2D(0, 0);
    }

    protected void drawObject(Graphics g, Vector2D[] points) {
        g.setColor(Color.lightGray);
        fillPolygon(g, points);
        g.setColor(Color.black);
        drawPolygon(g, points);
    }
}