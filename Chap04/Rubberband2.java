import java.awt.*;
import java.awt.event.*;

public class Rubberband2 extends Canvas {
    public static void main(String[] args) {
         new Rubberband2();
    }

    private static final int width = 400;
    private static final int height = 400;
    private int startX;
    private int startY;
    protected Color colors;

    private Rubberband2() {
        super();
        setSize(width, height);
        setBackground(Color.white);
        setForeground(Color.black);

        addMouseListener(new MouseAdapter () {
            public void mousePressed(MouseEvent me) {
                int modifiers = me.getModifiersEx();
                if ((modifiers & MouseEvent.BUTTON2_DOWN_MASK) != 0)
                  colors = Color.red;
                else
                  colors = Color.black;
                startX = me.getX();
                startY = me.getY();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                Graphics g = getGraphics();
                update(g);
                int x = me.getX();
                int y = me.getY();
                g.setColor(colors);
                g.drawLine(startX, startY, x, y);
            }
        });

        Frame f = new Frame("RubberBand2");
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