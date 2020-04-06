public class Tetrahedron extends Polyhedron {
    private static final float[][] tetraVertices = { {-1.0f, -1.0f, -1.0f}, {1.0f, 1.0f, -1.0f}, {1.0f, -1.0f, 1.0f}, {-1.0f, 1.0f, 1.0f} };
    private static final int[][] tetraFaces = { {0, 1, 2}, {1, 3, 2}, {0, 2, 3}, {0, 3, 1} };
    private static final int[][] tetraEdges = {{1, 3}, {3, 2}, {2, 1}, {3, 4}, {4, 2}, {4, 1}};
    private static final float[][] tetraFaceColors = { {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f} };
    protected Tetrahedron() {
        vertices   = tetraVertices;
        faces      = tetraFaces;
        edges      = tetraEdges;
        faceColors = tetraFaceColors;
    }
}
