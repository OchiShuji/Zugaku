import java.awt.*;
import java.awt.event.*;

public class CGDiamondBubble extends CGCanvas {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java CGDiamondBubble #");
        }
        else {
            (new CGDiamondBubble("CGDiamondBubble",  Integer.parseInt(args[0]))).showFrame();
        }
    }

    protected int centerX;
    protected int centerY;
    protected Vector2D[] points;

    protected CGDiamondBubble(String name, int numberOfPoints) {
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
                points = new Vector2D[numberOfPoints];
                for (int i = 0; i < numberOfPoints; i++) {
                   double theta = 2.0 * Math.PI * i / numberOfPoints;
                   points[i] = new Vector2D(radius*Math.cos(theta), radius*Math.sin(theta)); 
                }
                drawPolygon(g, points);
                for (int j = 0; j < numberOfPoints; j++) {
                    for (int k = j + 2; k < numberOfPoints; k++) {
                        drawLine(g, points[j], points[k]);
                    }
                }
            }           
        });
    }
}