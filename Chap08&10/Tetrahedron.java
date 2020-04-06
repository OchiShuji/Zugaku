import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import javax.media.opengl.awt.*;

public class Tetrahedron extends GLCanvas implements GLEventListener {
    public static void main(String[] args) {
        if (args.length == 3)
          (new Tetrahedron("Tetrahedron", args)).showFrame();
        else
          (new Tetrahedron("Tetrahedron")).showFrame();
    }

    private Frame f;
    protected GL2 gl;
    protected GLU glu;
    protected double eye_x = 4.0;
    protected double eye_y = 3.0;
    protected double eye_z = 7.0;

    protected Tetrahedron(String name) {
        super();
        setSize(500, 500);
        addGLEventListener(this);

        f = new Frame(name);
        f.add(this);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    protected Tetrahedron(String name, String[] args) {
        this(name);
        eye_x = Double.parseDouble(args[0]);
        eye_y = Double.parseDouble(args[1]);
        eye_z = Double.parseDouble(args[2]);
    }

    protected void showFrame() {
        f.setVisible(true);
    }

    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_CULL_FACE);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        final double fieldOfView = 25.0, near = 1.0, far = 20.0;
        double aspect = (double) w / (double) h;

        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(fieldOfView, aspect, near, far);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(eye_x, eye_y, eye_z, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    }

    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        cubeDisplay();
    }

    static float[][] vertices = { {-1.0f, -1.0f, -1.0f}, {1.0f, 1.0f, -1.0f}, {1.0f, -1.0f, 1.0f}, {-1.0f, 1.0f, 1.0f} };
    static int[][] faces = { {0, 1, 2}, {1, 3, 2}, {0, 2, 3}, {0, 3, 1} };
    static float[][] colors = { {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f} };

    protected void cubeDisplay() {
        gl.glBegin(GL2.GL_TRIANGLES);
        for (int i = 0; i < faces.length; i++) {
            gl.glColor3fv(colors[i], 0);
            for (int j = 0; j < faces[i].length; j++)
              gl.glVertex3fv(vertices[faces[i][j]], 0);
        }
        gl.glEnd();
        gl.glFlush();
    }

    public void dispose(GLAutoDrawable drawable) {

    }
}