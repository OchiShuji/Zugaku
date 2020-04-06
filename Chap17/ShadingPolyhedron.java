import javax.media.opengl.*;

public abstract class ShadingPolyhedron extends Polyhedron {
    protected float[][] faceNormals;
    protected float[]   diffuse;
    protected float[]   specular;
    protected float shininess = 0.0f;

    public void display(GL2 gl) {
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE, diffuse, 0);
        gl.glMaterialfv(GL2 .GL_FRONT, GL2.GL_SPECULAR, specular, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, shininess);
        gl.glShadeModel(GL2.GL_FLAT);
        for (int i = 0; i < faces.length; i++) {
            gl.glBegin(GL2.GL_POLYGON);
            gl.glNormal3fv(faceNormals[i], 0);
            for (int j = 0; j < faces[i].length; j++) {
                gl.glVertex3fv(vertices[faces[i][j]], 0);
            }
            gl.glEnd();
        }
    }
}