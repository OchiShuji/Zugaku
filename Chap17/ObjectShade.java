import javax.media.opengl.*;

public abstract class ObjectShade extends ObjectTranslate2 {
    protected Light2 light = new Light2();

    protected ObjectShade(String name) {
        super(name);
    }

    public void init(GLAutoDrawable drawable) {
        baseInit(drawable);
        light.parameter(gl);
        objectInit();
        mouseInit(drawable);
        motionInit(drawable);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        cameraInit(w, h);
        light.position(gl);
        positionInit();
    }
}