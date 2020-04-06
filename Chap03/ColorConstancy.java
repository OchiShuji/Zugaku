import java.awt.*;
import java.awt.event.*;

public class ColorConstancy extends Canvas{
    public static void main(String args[]){
        new ColorConstancy("ColorConstancy");
    }

    private static final int width = 600;
    private static final int height = 600;
    private static int centerX1 = 150;
    private static int centerX2 = 450;
    private static int centerY = 300;
    private static int radius2 = 120 * 120;

    protected ColorConstancy(String name) {
        super();
        setSize(width, height);

        Frame f = new Frame(name);
        f.add(this);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public void paint(Graphics g) {
        for (int y = 0; y < height; y++) {
            final int dy = (y - centerY) * (y - centerY);
            for (int x = 0; x < 300; x++) {
                final int dx = (x - centerX1) * (x - centerX1);
                if (dx + dy < radius2)
                  g.setColor(Color.gray);
                else
                  g.setColor(Color.darkGray);
                g.fillRect(x, y, 1, 1);
            }
            for (int x = 300; x < 600; x++){
                final int dx = (x - centerX2) * (x - centerX2);
                if (dx + dy < radius2)
                  g.setColor(Color.gray);
                else
                  g.setColor(Color.lightGray);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}