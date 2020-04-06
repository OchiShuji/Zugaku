import java.awt.Color;
import javax.media.opengl.*;


public class HSBConeTranslate extends ObjectTranslate {
    public static void main(String[] args) {
        (new HSBConeTranslate("HSBConeTranslate")).showFrame();
    }
    protected HSBConeTranslate(String name) {
        super(name);
        object = new HSBCone();
    }
}

class HSBCone implements DisplayObject {
    final int NOP = 20;
    float[] apex = {0.0f, 1.0f, 0.0f};
    float[] center = {0.0f, -1.0f, 0.0f};
    float[] apexColor = {0.0f, 0.0f, 0.0f};
    float[] centerColor = {1.0f, 1.0f, 1.0f};
    public void display(GL2 gl) {
        float[][] circle = new float[NOP+1][];
        for (int i = 0; i <= NOP; i++) {
            double t = 2.0 * Math.PI * i / NOP;
            circle[i] = new float[3];
            circle[i][0] = (float)Math.sin(t);
            circle[i][1] = -1.0f;
            circle[i][2] = (float)Math.cos(t);
        }
        float[][] colors = new float[NOP+1][];
        Color[] c = new Color[NOP+1];
        for (int i = 0; i <= NOP; i++) {
            c[i] = Color.getHSBColor((float)i / NOP, 1.0f, 1.0f);
            colors[i] = c[i].getRGBColorComponents(null);
        }
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glColor3fv(apexColor, 0);
        gl.glVertex3fv(apex, 0);
        for (int i = 0; i <= NOP; i++) {
            gl.glColor3fv(colors[i], 0);
            gl.glVertex3fv(circle[i], 0);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glColor3fv(centerColor, 0);
        gl.glVertex3fv(center, 0);
        for (int i = 0; i <= NOP; i++) {
            gl.glColor3fv(colors[NOP-i], 0);
            gl.glVertex3fv(circle[NOP-i], 0);
        }
        gl.glEnd();
    }
}