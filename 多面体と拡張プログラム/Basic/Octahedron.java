public class Octahedron extends Polyhedron {
    private static final float[][] octaVertices = { {0.0f, (float)Math.sqrt(3), 0.0f}, {-(float)Math.sqrt(3), 0.0f, 0.0f}, {0.0f, 0.0f, (float)Math.sqrt(3)}, 
                                                    {(float)Math.sqrt(3), 0.0f, 0.0f}, {0.0f, 0.0f, -(float)Math.sqrt(3)}, {0.0f, -(float)Math.sqrt(3), 0.0f} };
    private static final int[][] octaFaces = { {0, 1, 2}, {0, 2, 3}, {0, 3, 4}, {0, 4, 1}, {2, 1, 5}, {3, 2, 5}, {4, 3, 5}, {1, 4, 5} };
    private static final int[][] octaEdges = { {0, 3}, {0, 4}, {0, 1}, {0, 2}, {5, 3}, {5, 4}, {5, 1}, {5, 2}, {3, 4}, {4, 1}, {1, 2}, {2, 3} };
    private static final float[][] octaFaceColors = { {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f},
                                                      {0.0f, 0.5f, 0.5f}, {0.5f, 0.0f, 0.5f}, {0.5f, 0.5f, 0.0f}, {0.5f, 0.0f, 0.0f} };
    protected Octahedron() {
        vertices   = octaVertices;
        faces      = octaFaces;
        edges      = octaEdges;
        faceColors = octaFaceColors;
    }
}