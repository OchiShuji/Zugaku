import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.*;
import com.jogamp.opengl.util.*;

public abstract class ObjectRotate extends ObjectAngle {
    protected int prevX;
    protected int prevY;

    protected ObjectRotate(String name) {
        super(name);
        final Animator amimator = new Animator(this);
        amimator.start();
    }

    public void init(GLAutoDrawable drawable) {
        baseInit(drawable);
        objectInit();
        mouseInit(drawable);
        motionInit(drawable);
    }

    protected void mouseInit(GLAutoDrawable drawable) {
        ((GLCanvas)drawable).addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
            }
        });
    }

    protected void motionInit(GLAutoDrawable drawable) {
        ((GLCanvas)drawable).addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                Dimension size = e.getComponent().getSize();
                float thetaY = 360.0f * ((float)(x - prevX) / size.width);
                float thetaX = 360.0f * ((float)(y - prevY) / size.height);
                rotx += thetaX;
                roty += thetaY;
                prevX = x;
                prevY = y;
            }
        });
    }
}