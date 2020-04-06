import javax.media.opengl.*;

public class HiddenCones extends WireCones {
    public void display(GL2 gl) {
        gl.glEnable(GL2.GL_POLYGON_OFFSET_FILL);
        gl.glPolygonOffset(1.0f, 1000.0f);

        final int NOC = 16;
        float[] background = {0.0f, 0.0f, 0.0f};
        float[] foreground = {1.0f, 1.0f, 0.0f};
        for (int i = 0; i < NOC; i++) {
            double t = 2.0 * Math.PI * i / NOC;
            gl.glPushMatrix();
            gl.glTranslated(1.6 * Math.sin(t), 0.0, 1.6 * Math.cos(t));
            gl.glScalef(0.3f, 1.4f, 0.3f);
            gl.glColor3fv(foreground, 0);
            displayEdges(gl);
            gl.glColor3fv(background, 0);
            displayFaces(gl);
            gl.glPopMatrix();
        }
    }

    protected void displayFaces(GL2 gl) {
        final int NOP = 20;
        float[] apex = {0.0f, 1.0f, 0.0f};
        float[][] circle = new float[NOP+1][];
        for (int i = 0; i <= NOP; i++) {
            double t = 2.0 * Math.PI * i / NOP;
            circle[i] = new float[3];
            circle[i][0] = (float)Math.sin(t);
            circle[i][1] = -1.0f;
            circle[i][2] = (float)Math.cos(t);
        }
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < NOP; i++) {
            gl.glVertex3fv(circle[NOP-i-1], 0);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex3fv(apex, 0);
        for (int i = 0; i <= NOP; i++) {
            gl.glVertex3fv(circle[i], 0);
        }
        gl.glEnd();
    }
}