import java.awt.*;
import java.awt.event.*;

public class Confirmation extends Canvas implements MouseListener {
    public static void main(String[] args) {
        new Confirmation();
    }

    private static final int width = 200;
    private static final int height = 200;

    private Confirmation() {
        super();
        setSize(width, height);
        setBackground(Color.white);
        addMouseListener(this);

        Frame f = new Frame("Confirmation");
        f.add(this);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public void mousePressed(MouseEvent me) {
        setBackground(Color.red);
        repaint();
    }

    public void mouseReleased(MouseEvent me) {
        setBackground(Color.green);
        repaint();
    }

    public void mouseEntered(MouseEvent me) {
        setBackground(Color.blue);
        repaint();
    }

    public void mouseExited(MouseEvent me) {
        setBackground(Color.white);
        repaint();
    }

    public void mouseClicked(MouseEvent me) {
        setBackground(Color.yellow);
        repaint();
    }
}