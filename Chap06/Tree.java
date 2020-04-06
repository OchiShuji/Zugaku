import java.awt.*;

public class Tree extends LSystem {
    public static void main(String[] args) {
        if (args.length != 1)
          System.err.println("Usage: java Tree #iterarion");
        else
          (new Tree("Tree", Integer.parseInt(args[0]))).showFrame();
    }

    protected Tree(String name,int times) {
        super(name, times);
    }

    protected void setData() {
        setOrigin(300, 540);
        setRange(5.0);
        initPoints = new Vector2D[2]; 
        initPoints[0] = new Vector2D(0.0, 0.0);
        initPoints[1] = new Vector2D(0.0, 1.0);

        m = new Matrix2X2[2];
        v = new Vector2D[2];

        m[0] = Matrix2X2.scale(1/Math.sqrt(2)).multiply(Matrix2X2.rotate(-Math.PI / 5));
        m[1] = Matrix2X2.scale(1/Math.sqrt(2)).multiply(Matrix2X2.rotate(Math.PI / 5));
        v[0] = initPoints[1];
        v[1] = initPoints[1];
    }

    protected void drawObject(Graphics g, Vector2D[] points) {
        drawPolyline(g, points);
    }

}