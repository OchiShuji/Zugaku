import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.*;

public abstract class ObjectTranslate2 extends ObjectSpin {
    private final float transRatio = 5.0f;
    private double[] offset = {0.0, 0.0, 0.0};
    private Rotation state = null;
    //private Rotation ident = RotMatrix.identity();
    private Rotation ident = Quaternion.identity();
    protected ObjectTranslate2(String name) {
        super(name);
    }

    protected void motionInit(GLAutoDrawable drawable) {
        ((GLCanvas)drawable).addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                Dimension size = e.getComponent().getSize();
                float deltaX = x - prevX;
                float deltaY = y - prevY;
                int modifier = e.getModifiers();
                if ((modifier & MouseEvent.BUTTON1_MASK) != 0) {
                    angle = Math.sqrt(deltaX*deltaX + deltaY*deltaY)*rotateRatio / Math.max(size.width, size.height);
                    glu.gluUnProject(origin[0]+deltaY, origin[1]+deltaX, origin[2], modelMatrix, 0, projMatrix, 0, viewport, 0, axis, 0);
                    if ((modifier & InputEvent.SHIFT_MASK) != 0) {
                        offset[2] += deltaY * transRatio / size.height;
                    }
                }
                else {
                    if ((modifier & MouseEvent.SHIFT_MASK) == 0) {
                        offset[0] += deltaX * transRatio / size.height;
                        offset[1] -= deltaY * transRatio / size.height;
                    }
                }
                prevX = x;
                prevY = y;
            }
        });
    }

    protected void positionInit() {
        offset[0] = offset[1] = 0.0;
        offset[2] = depth;
        state = ident.rotAroundAxis(rotx, 1.0, 0.0, 0.0).rotAroundAxis(roty, 0.0, 1.0, 0.0).rotAroundAxis(rotz, 0.0, 0.0, 1.0);
        gl.glGetDoublev(GL2.GL_PROJECTION_MATRIX, projMatrix, 0);
        gl.glGetIntegerv(GL2.GL_VIEWPORT, viewport, 0);
    }

    protected void setMatrix() {
        state = state.rotAroundAxis(angle, axis[0], axis[1], axis[2]);
        state.setMatrix(modelMatrix, offset);
        gl.glLoadIdentity();
        gl.glMultMatrixd(modelMatrix, 0);
        gl.glLoadIdentity();
        gl.glMultMatrixd(modelMatrix, 0);
        glu.gluProject(0.0, 0.0, 0.0, modelMatrix, 0, projMatrix, 0, viewport, 0, origin, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    }
}