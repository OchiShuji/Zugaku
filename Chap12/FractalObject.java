import javax.media.opengl.*;

public abstract class FractalObject implements DisplayObject {
    protected int times;
    protected Polyhedron primitive;
    protected double s;
    protected double v[][];

    protected FractalObject(int times) {
        this.times = times;
    }

    public void display(GL2 gl) {
        fractal(gl, times);
    }

    protected void fractal(GL2 gl, int l) {
        if (l > 0) {
            for (int i = 0; i < v.length; i++) {
                gl.glPushMatrix();
                gl.glTranslated(v[i][0], v[i][1], v[i][2]);
                gl.glScaled(s, s, s);
                fractal(gl, l - 1);
                gl.glPopMatrix();
            }
        }
        else {
            primitive.display(gl);
        }
    }
}