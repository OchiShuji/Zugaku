import javax.media.opengl.*;

public class CubePolygon extends CubePosition {
    public static void main(String[] args) {
        if (args.length == 3)
          (new CubePolygon("CubePolygon", args)).showFrame();
        else
          (new CubePolygon("CubePolygon")).showFrame();
    }

    protected CubePolygon(String name) {
        super(name);
    }

    protected CubePolygon(String name, String[] args) {
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