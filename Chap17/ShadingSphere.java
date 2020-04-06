import javax.media.opengl.*;

public class ShadingSphere extends ShadingSubdivision {
    protected ShadingSphere(int times) {
        super(times);
    }

    protected void subdivision(float[] pnt0, float[] pnt1, float[] pnt2, GL2 gl, int l) {
        if (l == 0) {
            gl.glShadeModel(GL2.GL_SMOOTH);
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glNormal3fv(pnt0, 0);
            gl.glVertex3fv(pnt0, 0);
            gl.glNormal3fv(pnt1, 0);
            gl.glVertex3fv(pnt1, 0);
            gl.glNormal3fv(pnt2, 0);
            gl.glVertex3fv(pnt2, 0);
            gl.glEnd();
        }
        else {
            float[] pnt01 = split(pnt0, pnt1);
            float[] pnt12 = split(pnt1, pnt2);
            float[] pnt20 = split(pnt2, pnt0);
            subdivision(pnt0, pnt01, pnt20, gl, l-1);
            subdivision(pnt1, pnt12, pnt01, gl, l-1);
            subdivision(pnt2, pnt20, pnt12, gl, l-1);
            subdivision(pnt01, pnt12, pnt20, gl, l-1);
        }
    }
}