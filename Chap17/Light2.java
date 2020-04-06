import javax.media.opengl.*;

public class Light2 {
    protected float[] ambient = { 0.2f, 0.2f, 0.2f, 1.0f };
    protected float[] diffuse = { 1.0f, 1.0f, 1.0f, 1.0f };
    protected float[] specular = { 0.9f, 0.9f, 0.9f, 1.0f };
    //protected float[] position = { 5.0f, 5.0f, 0.0f, 1.0f };
    protected float[] position = { 5.0f, 5.0f, 0.0f, 0.0f }; 

    public Light2() {
    }
    public Light2(float[] ambient, float[] diffuse, float[] specular, float[] position) {
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.position = position;
    }

    public void parameter(GL2 gl) {
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular, 0);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_NORMALIZE);
    }

    public void position(GL2 gl) {
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position, 0);
    }
}