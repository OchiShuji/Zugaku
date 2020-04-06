import javax.media.opengl.*;

public abstract class HiddenPolyhedron implements DisplayObject {
    protected float[][] vertices;
    protected int[][]   faces;
    protected int[][]   edges;

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
        for (int i = 0; i < faces.length; i++) {
            gl.glBegin(GL2.GL_POLYGON);
            for (int j = 0; j < faces[i].length; j++) {
                gl.glVertex3fv(vertices[faces[i][j]], 0);
            }
            gl.glEnd();
        }
    }

    protected void displayEdges(GL2 gl) {
        gl.glBegin(GL2.GL_LINES);
        for (int i = 0; i < edges.length; i++) {
             gl.glVertex3fv(vertices[edges[i][0]], 0);
             gl.glVertex3fv(vertices[edges[i][1]], 0);
        }
        gl.glEnd();
    }

    public int vertices() {
        return vertices.length;
    }
    public float vertex(int id, int j) {
        return vertices[id][j];
    }
    public int faces() {
        return faces.length;
    }
    public int faceVertices(int id) {
        return faces[id].length;
    }
    public float faceVertex(int id, int i, int j) {
        return vertices[faces[id][i]][j];
    }
    public int edges() {
        return edges.length;
    }
    public float edgeVertex(int id, int i, int j) {
        return vertices[edges[id][i]][j];
    }
}