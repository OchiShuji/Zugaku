import java.awt.*;

public class Pentaflake extends Fractal {
    public static void main(String[] args) {
        if (args.length != 1) 
          System.err.println("Usage: java Pentaflake #iteration");
        else
          (new Pentaflake("Pentaflake", Integer.parseInt(args[0]))).showFrame();
    }

    protected Pentaflake(String name, int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(300, 299);
        setRange(2.5);

        initPoints = new Vector2D[5];
        initPoints[0] = new Vector2D(Math.cos(Math.PI / 10), Math.sin(Math.PI / 10));
        initPoints[1] = new Vector2D(0.0, 1.0);
        initPoints[2] = new Vector2D(Math.cos(9 * Math.PI / 10), Math.sin(9 * Math.PI / 10));
        initPoints[3] = new Vector2D(Math.cos(13 * Math.PI / 10), Math.sin(13 * Math.PI / 10));
        initPoints[4] = new Vector2D(Math.cos(17 * Math.PI / 10), Math.sin(17 * Math.PI / 10));

        m = new Matrix2X2[6];
        v = new Vector2D[6];
        m[0] = Matrix2X2.scale((3 - Math.sqrt(5)) / 2);
        m[1] = Matrix2X2.scale((3 - Math.sqrt(5)) / 2);
        m[2] = Matrix2X2.scale((3 - Math.sqrt(5)) / 2);
        m[3] = Matrix2X2.scale((3 - Math.sqrt(5)) / 2);
        m[4] = Matrix2X2.scale((3 - Math.sqrt(5)) / 2);
        m[5] = Matrix2X2.scale((3 - Math.sqrt(5)) / 2).multiply(Matrix2X2.rotate(Math.PI));
        v[0] = initPoints[0].subtract(m[0].apply(initPoints[0]));
        v[1] = initPoints[1].subtract(m[2].apply(initPoints[1]));
        v[2] = initPoints[2].subtract(m[3].apply(initPoints[2]));
        v[3] = initPoints[3].subtract(m[4].apply(initPoints[3]));
        v[4] = initPoints[4].subtract(m[4].apply(initPoints[4]));
        v[5] = new Vector2D(0, 0);
    }

    protected void drawObject(Graphics g, Vector2D[] points) {
        g.setColor(Color.lightGray);
        fillPolygon(g, points);
        g.setColor(Color.black);
        drawPolygon(g, points);
    }
}