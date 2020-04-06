import javax.media.opengl.*;

public class HiddenCube2 implements DisplayObject {
  private static final float[][] cubeVertices =   
  { { -1.0f, -1.0f, -1.0f }, {  1.0f, -1.0f, -1.0f }, { 1.0f,  1.0f, -1.0f },
    { -1.0f,  1.0f, -1.0f }, { -1.0f, -1.0f,  1.0f }, { 1.0f, -1.0f,  1.0f },
    {  1.0f,  1.0f,  1.0f }, { -1.0f,  1.0f,  1.0f } };

  private static final int[][] cubeEdges =       
  { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 4 }, { 1, 5 }, { 2, 6 },
    { 3, 7 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 } };
  
  private static final int[][] cubeFaces =        
  { { 1, 2, 6, 5 }, { 2, 3, 7, 6 }, { 4, 5, 6, 7 }, { 0, 4, 7, 3 },
    { 0, 1, 5, 4 }, { 0, 3, 2, 1 } };

    public void display(GL2 gl) {
        gl.glEnable(GL2.GL_POLYGON_OFFSET_FILL);
        gl.glPolygonOffset(1.0f, 1.0f);
        float[] background = {0.0f, 0.0f, 0.0f};
        float[] foreground = {1.0f, 1.0f, 0.0f};
        gl.glPushMatrix();
        gl.glColor3fv(foreground, 0);
        displayEdges(gl);
        gl.glColor3fv(background, 0);
        displayFaces(gl);
        gl.glPopMatrix();
        }

    public void displayFaces(GL2 gl) {
        for (int i = 0; i < cubeFaces.length; i++) {
            gl.glBegin(GL2.GL_POLYGON);
            for (int j = 0; j < cubeFaces[i].length; j++) {
                gl.glVertex3fv(cubeVertices[cubeFaces[i][j]], 0);
            }
            gl.glEnd();
        }
    }

    protected void displayEdges(GL2 gl) {
        gl.glBegin(GL2.GL_LINES);
        for (int i = 0; i < edges.length; i++) {
             gl.glVertex3fv(cubeVertices[cubeEdges[i][0]], 0);
             gl.glVertex3fv(cubeVertices[cubeEdges[i][1]], 0);
        }
        gl.glEnd();
    }

}
