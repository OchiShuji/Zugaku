public class Octahedron extends Polyhedron {
    private static final float[][] octaVertices = 
    { {0, (float)Math.sqrt(3), 0}, {-(float)Math.sqrt(3), 0, 0},  {0, 0, (float)Math.sqrt(3)}, 
      {(float)Math.sqrt(3), 0, 0}, {0, 0, -(float)Math.sqrt(3)},  {0, -(float)Math.sqrt(3), 0} };
    private static final int[][] octaFaces = 
    { {1, 2, 3}, {1, 3, 4}, {1, 4, 5}, {1, 5, 2}, 
      {3, 2, 6}, {4, 3, 6}, {5, 4, 6}, {2, 5, 6} };
    private static final int[][] octaEdges = 
    { {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 2}, {1, 3},
      {1, 4}, {1, 5}, {6, 5}, {6, 2}, {6, 3}, {6, 4} };
    private static final float[][] octaFaceColors = 
    { {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f}, 
      {0.0f, 1.0f, 0.0f}, {0.0f, 0.0f, 1.0f}, {0.5f, 0.5f, 0.5f}, {1.0f, 1.0f, 1.0f} };
    protected Octahedron() {
        vertices   = octaVertices;
        faces      = octaFaces;
        edges      = octaEdges;
        faceColors = octaFaceColors;
    }
}