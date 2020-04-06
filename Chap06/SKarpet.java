import java.awt.*;

public class SKarpet extends Fractal {
    public static void main(String[] args) {
        if (args.length != 1)
          System.err.println("Usage: java SKarpet #iteration");
        else
          (new SKarpet("SKarpet", Integer.parseInt(args[0]))).showFrame();
    }

    protected SKarpet(String name, int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(300, 299);
        setRange(1.2);

        initPoints = new Vector2D[4];
        initPoints[0] = new Vector2D( 0.5,  0.5);
        initPoints[1] = new Vector2D(-0.5,  0.5);
        initPoints[2] = new Vector2D(-0.5, -0.5);
        initPoints[3] = new Vector2D( 0.5, -0.5);

        m = new Matrix2X2[8];
        v = new Vector2D[8];
        m[0] = Matrix2X2.scale(1.0 / 3.0);
        m[1] = Matrix2X2.scale(1.0 / 3.0);
        m[2] = Matrix2X2.scale(1.0 / 3.0);
        m[3] = Matrix2X2.scale(1.0 / 3.0);
        m[4] = Matrix2X2.scale(1.0 / 3.0);
        m[5] = Matrix2X2.scale(1.0 / 3.0);
        m[6] = Matrix2X2.scale(1.0 / 3.0);
        m[7] = Matrix2X2.scale(1.0 / 3.0);
        v[0] = m[0].multiply(Matrix2X2.scale(2.0)).apply(initPoints[0]);
        v[1] = m[1].apply(initPoints[1].subtract(initPoints[0])).add(v[0]);
        v[2] = m[2].multiply(Matrix2X2.scale(2.0)).apply(initPoints[1]);
        v[3] = m[3].apply(initPoints[2].subtract(initPoints[1])).add(v[2]);
        v[4] = m[4].multiply(Matrix2X2.scale(2.0)).apply(initPoints[2]);
        v[5] = m[5].apply(initPoints[3].subtract(initPoints[2])).add(v[4]);
        v[6] = m[6].multiply(Matrix2X2.scale(2.0)).apply(initPoints[3]);
        v[7] = m[7].apply(initPoints[0].subtract(initPoints[3])).add(v[6]);

    }
    
    protected void drawObject(Graphics g, Vector2D[] points) {
        g.setColor(Color.lightGray);
        fillPolygon(g, points);
        g.setColor(Color.black);
        drawPolygon(g, points);
    }
}