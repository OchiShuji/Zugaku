public class HiddenTetrahedron extends HiddenPolyhedron {
    private static final float[][] tetraVertices = { {-1.0f, -1.0f, -1.0f}, {1.0f, 1.0f, -1.0f}, {1.0f, -1.0f, 1.0f}, {-1.0f, 1.0f, 1.0f} };
    private static final int[][] tetraFaces = { {0, 1, 2}, {1, 3, 2}, {0, 2, 3}, {0, 3, 1} };
    private static final int[][] tetraEdges = {{0, 2}, {2, 1}, {1, 0}, {2, 3}, {3, 1}, {3, 0}};
    protected HiddenTetrahedron() {
        vertices   = tetraVertices;
        faces      = tetraFaces;
        edges      = tetraEdges;
    }
}
