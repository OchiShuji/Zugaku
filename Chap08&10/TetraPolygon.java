import javax.media.opengl.*;

public class TetraPolygon extends Tetrahedron {
    public static void main(String[] args) {
        if (args.length == 3)
          (new TetraPolygon("TetraPolygon", args)).showFrame();
        else
          (new TetraPolygon("TetraPolygon")).showFrame();
    }

    protected TetraPolygon(String name) {
        super(name);
    }

    protected TetraPolygon(String name, String[] args) {
        super(name, args);
    }
    
    protected void cubeDisplay() {
        for (int i = 0; i < faces.length; i++) {
            gl.glBegin(GL2.GL_POLYGON);
            gl.glColor3fv(colors[i], 0);
            for (int j = 0; j < faces[i].length; j++)
              gl.glVertex3fv(vertices[faces[i][j]], 0);
            gl.glEnd();
        }
        gl.glFlush();
    }
}