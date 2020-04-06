import javax.media.opengl.*;

public abstract class Polyhedron implements DisplayObject {
    protected float[][] vertices;
    protected int[][]   faces;
    protected int[][]   edges;
    protected float[][] faceColors;

    public void display(GL2 gl) {
        for (int i = 0; i < faces.length; i++) {
            gl.glBegin(GL2.GL_POLYGON);
            gl.glColor3fv(faceColors[i], 0);
            for (int j = 0; j < faces[i].length; j++) {
                gl.glVertex3fv(vertices[faces[i][j]], 0);
            }
            gl.glEnd();
        }
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