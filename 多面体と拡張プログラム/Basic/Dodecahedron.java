public class Dodecahedron extends Polyhedron {
    protected static final float phi = (1 + (float)Math.sqrt(5)) / 2;
    private static final float[][] dodecaVertices = 
    { {-1/phi, phi, 0}, {1/phi, phi, 0}, {-1, 1, 1}, {1, 1, 1}, {1, 1, -1}, {-1, 1, -1}, {0, 1/phi, phi}, {0, 1/phi, -phi}, {-phi, 0, 1/phi}, {phi, 0, 1/phi}, {phi, 0, -1/phi}, {-phi, 0, -1/phi}, {0, -1/phi, phi}, {0, -1/phi, -phi}, {-1, -1, 1}, {1, -1, 1}, {1, -1, -1}, {-1, -1, -1}, {-1/phi, -phi, 0}, {1/phi, -phi, 0}};
    private static final int[][] dodecaFaces = 
    { {0, 2, 6, 3, 1}, {1, 3, 9, 10, 4}, {1, 4, 7, 5, 0}, {0, 5, 11, 8, 2}, {6, 2, 8, 14, 12}, {6, 12, 15, 9, 3}, {4, 10, 16, 13, 7}, {5, 7, 13, 17, 11}, {8, 11, 17, 18, 14}, {12, 14, 18, 19, 15}, {13, 16, 19, 18, 17}, {9, 15, 19, 16, 10} };
    private static final int[][] dodecaEdges = 
    { {0, 2}, {0, 5}, {1, 3}, {1, 4}, {5, 7}, {4, 7}, {2, 6}, {3, 6}, {3, 9}, {4, 10}, 
      {9, 10}, {2, 8}, {11, 8}, {11, 6}, {8, 14}, {14, 12}, {12, 15}, {9, 15}, {10, 16}, {13, 16}, 
      {17, 13}, {6, 17}, {6, 8}, {17, 18}, {14, 18}, {18, 19}, {15, 19}, {16, 19}, {11, 17}, {0, 1}, };
    private static final float[][] dodecaFaceColors = 
    { {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f}, {1.0f, 0.0f, 0.0f}, 
      {0.0f, 0.5f, 0.5f}, {0.5f, 0.0f, 0.5f}, {0.5f, 0.5f, 0.0f}, {0.5f, 0.0f, 0.0f},
      {0.0f, 1.0f, 0.0f}, {0.0f, 0.5f, 0.0f}, {0.0f, 0.0f, 1.0f}, {0.0f, 0.0f, 0.5f} };
    protected Dodecahedron() {
        vertices   = dodecaVertices;
        faces      = dodecaFaces;
        edges      = dodecaEdges;
        faceColors = dodecaFaceColors;
    }
}
