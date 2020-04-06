import javax.media.opengl.*;

public class ShadingSubdivision extends ShadingIcosahedron {
    private int times;

    protected ShadingSubdivision(int times) {
        super();
        this.times = times;
    }

    public void display(GL2 gl) {
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE, diffuse, 0);
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, specular, 0);
        gl.glMaterialf(GL2.GL_FRONT, GL2.GL_SHININESS, shininess);
        gl.glShadeModel(GL2.GL_FLAT);
        for (int i = 0; i < faces.length; i++) {
            subdivision(vertices[faces[i][0]], vertices[faces[i][1]], vertices[faces[i][2]], gl, times);
        }
    }

    protected void subdivision(float[] pnt0, float[] pnt1, float[] pnt2, GL2 gl, int l) {
        if (l == 0) {
            gl.glShadeModel(GL2.GL_FLAT);
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glNormal3fv(normal(pnt0, pnt1, pnt2), 0);
            gl.glVertex3fv(pnt0, 0);
            gl.glVertex3fv(pnt1, 0);
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

    protected float[] normal(float[] pnt0, float[] pnt1, float[] pnt2) {
        float[] answer = new float[3];
        for (int i = 0; i < 3; i++)
          answer[i] = pnt0[i] + pnt1[i] + pnt2[i];
        return answer;
    }

    protected float[] split(float[] pnt0, float[] pnt1) {
        float[] ans = new float[3];
        for (int i = 0; i < 3; i++)
          ans[i] = pnt0[i] + pnt1[i];
        float ratio =
           (float)(R_CS / Math.sqrt(ans[0]*ans[0]+ans[1]*ans[1]+ans[2]*ans[2]));
        for (int i = 0; i < 3; i++)
          ans[i] *= ratio;
        return ans;
    }
}