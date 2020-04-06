public class Dodecahedron extends Polyhedron {
    protected static final float phi = (1 + (float)Math.sqrt(5)) / 2;
    private static final float[][] dodecaVertices = 
    { {-1/phi, phi, 0}, {1/phi, phi, 0}, {-1, 1, 1}, {1, 1, 1}, {1, 1, -1}, {-1, 1, -1}, {0, 1/phi, phi}, {0, 1/phi, -phi}, {-phi, 0, 1/phi}, {phi, 0, 1/phi}, {phi, 0, -1/phi}, {-phi, 0, -1/phi}, {0, -1/phi, phi}, {0, -1/phi, -phi}, {-1, -1, 1}, {1, -1, 1}, {1, -1, -1}, {1, -1, -1}, {-1/phi, -phi, 0}, {1/phi, -phi, 0}};
    private static final int[][] dodecaFaces = 
    { {1, 3, 7 ,4, 2}, {2, 4, 10, 11, 5}, {2, 5, 8, 6, 1}, {1, 6, 12, 9, 3}, {7, 3, 9, 15, 13}, {7, 13, 16, 10, 4}, {5, 11, 17, 14, 8}, {6, 8, 14, 18, 12}, {9, 12, 18, 19, 15}, {13, 15, 19, 20, 16}, {14, 17, 20, 19, 18}, {10, 16, 20, 17, 11} };
    private static final int[][] dodecaEdges = 
    { {0, 2}, {0, 5}, {1, 3}, {1, 4}, {5, 7}, {4, 7}, {2, 6}, {3, 6}, {3, 9}, {4, 10}, 
      {9, 10}, {2, 8}, {11, 8}, {11, 6}, {8, 14}, {14, 12}, {12, 15}, {9, 15}, {10, 16}, {13, 16}, 
      {17, 13}, {6, 17}, {6, 8}, {17, 18}, {14, 18}, {18, 19}, {15, 19}, {16, 19}, {11, 17}, {0, 1}, };
    private static final float[][] dodecaFaceColors = 
    { {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f}, 
      {0.0f, 1.0f, 0.0f}, {0.0f, 0.0f, 1.0f}, {0.5f, 0.5f, 0.5f}, {1.0f, 1.0f, 1.0f},
      {0.5f, 0.5f, 0.0f}, {0.5f, 0.0f, 0.5f}, {0.0f, 0.5f, 0.5f}, {0.3f, 0.3f, 0.3f} };
    protected Dodecahedron() {
        vertices   = dodecaVertices;
        faces      = dodecaFaces;
        edges      = dodecaEdges;
        faceColors = dodecaFaceColors;
    }
}
