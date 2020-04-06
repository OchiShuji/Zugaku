import javax.media.opengl.*;

public class ShadingCylinder extends Polyhedron {
    protected float[][] Normals;
    protected float diffuse[];
    protected float specular[];
    protected float shininess = 0.0f;
    protected float[][] circleB;
    protected float[][] circleU;
    protected float[][] normalB;
    protected float[][] normalU;
    protected float[][] normalS;
    protected int NOP;


    protected ShadingCylinder(int num) {
        super();
        NOP = num;

    }

    public void display(GL2 gl) {
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE, diffuse, 0);
        gl.glMaterialfv(GL2 .GL_FRONT, GL2.GL_SPECULAR, specular, 0);
        gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, shininess);
        gl.glShadeModel(GL2.GL_SMOOTH);
        for (int i = 0; i < NOP; i++) {
            double t = 2.0 * Math.PI * i / NOP;
            circleB[i] = new float[3];
            circleB[i][0] = (float)Math.sin(t);
            circleB[i][1] = -1.0f;
            circleB[i][2] = (float)Math.cos(t);
        }
        for (int i = 0; i < NOP; i++) {
            double t = 2.0 * Math.PI * i / NOP;
            circleU[i] = new float[3];
            circleU[i][0] = (float)Math.sin(t);
            circleU[i][1] = 1.0f;
            circleU[i][2] = (float)Math.cos(t);
        }
        gl.glBegin(GL2.GL_QUAD_STRIP);
        for (int i = 0; i < NOP; i++) {
            double t = 2.0 * Math.PI * i / NOP;
            normalS[i] = new float[3];
            normalS[i][0] = (float)Math.sin(t);
            normalS[i][1] = 0.0f;
            normalS[i][2] = (float)Math.cos(t);
            gl.glVertex3fv(circleB[i], 0);
            gl.glNormal3fv(normalS[i], 0);
            gl.glVertex3fv(circleU[i], 0);
            gl.glNormal3fv(normalS[i], 0);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < NOP; i++) {
            normalB[i] = new float[3];
            normalB[i][0] = 0.0f;
            normalB[i][1] = -1.0f;
            normalB[i][2] = 0.0f;
            gl.glNormal3fv(normalB[i], 0);
            gl.glVertex3fv(circleB[i], 0);
        } 
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < NOP; i++) {
            normalU[i] = new float[3];
            normalU[i][0] = 0.0f;
            normalU[i][1] = 1.0f;
            normalU[i][2] = 0.0f;
            gl.glNormal3fv(normalU[i], 0);
            gl.glVertex3fv(circleU[i], 0);
        } 
        gl.glEnd();
    }

}