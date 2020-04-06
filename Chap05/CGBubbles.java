import java.awt.*;
import java.awt.event.*;

public class CGBubbles extends CGCanvas {
    public static void main(String[] args) {
        new CGBubbles("CGBubbles").showFrame();
    }

    protected int centerX;
    protected int centerY;

    protected CGBubbles(String name) {
        super(name);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me)  {
                centerX = me.getX();
                centerY = me.getY();
                setOrigin(centerX, centerY);
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                Graphics g = getGraphics();
                update(g);
                int x = me.getX();
                int y = me.getY();
                double radius = point(x ,y).norm();
                for (double i = 1; i > Vector2D.EPSILON; i = i * 0.5) {
                    drawCircle(g, point(centerX, centerY), i * radius);
                }
            }
        });
    }
}