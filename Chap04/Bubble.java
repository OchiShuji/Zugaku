import java.awt.*;
import java.awt.event.*;

public class Bubble extends Canvas {
    public static void main(String[] args) {
         new Bubble();
    }

    private static final int width = 400;
    private static final int height = 400;
    private int centerX;
    private int centerY;

    private Bubble() {
        super();
        setSize(width, height);
        setBackground(Color.white);
        setForeground(Color.black);

        addMouseListener(new MouseAdapter () {
            public void mousePressed(MouseEvent me) {
                centerX = me.getX();
                centerY = me.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                Graphics g = getGraphics();
                update(g);
                int x = me.getX();
                int y = me.getY();
                double R = Math.sqrt((double)(centerX - x)*(centerX - x)+(centerY - y)*(centerY - y));
                g.drawOval(centerX - (int)R, centerY - (int)R, 2*(int)R, 2*(int)R);
            }
        });

        Frame f = new Frame("Bubble");
        f.add(this);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}