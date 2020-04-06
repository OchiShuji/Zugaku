public class HiddenDodecahedron extends HiddenPolyhedron {
    protected static final float phi = (1 + (float)Math.sqrt(5)) / 2;
    private static final float[][] dodecaVertices = 
    { {-1/phi, phi, 0}, {1/phi, phi, 0}, {-1, 1, 1}, {1, 1, 1}, {1, 1, -1}, {-1, 1, -1}, {0, 1/phi, phi}, {0, 1/phi, -phi}, {-phi, 0, 1/phi}, {phi, 0, 1/phi}, {phi, 0, -1/phi}, {-phi, 0, -1/phi}, {0, -1/phi, phi}, {0, -1/phi, -phi}, {-1, -1, 1}, {1, -1, 1}, {1, -1, -1}, {-1, -1, -1}, {-1/phi, -phi, 0}, {1/phi, -phi, 0}};
    private static final int[][] dodecaFaces = 
    { {0, 2, 6, 3, 1}, {1, 3, 9, 10, 4}, {1, 4, 7, 5, 0}, {0, 5, 11, 8, 2}, {6, 2, 8, 14, 12}, {6, 12, 15, 9, 3}, {4, 10, 16, 13, 7}, {5, 7, 13, 17, 11}, {8, 11, 17, 18, 14}, {12, 14, 18, 19, 15}, {13, 16, 19, 18, 17}, {9, 15, 19, 16, 10} };
    private static final int[][] dodecaEdges = 
    { {0, 1}, {0, 2}, {0, 5}, {1, 3}, {1, 4}, {2, 6}, {3, 6}, {4, 7}, {5, 7}, {17, 18}, 
    {16, 19}, {2, 8}, {5, 11}, {3, 9}, {4, 10}, {11, 8}, {9, 10}, {6, 12}, {7, 13}, {8, 14}, 
    {11, 17}, {9, 15}, {10, 16}, {13, 16}, {13, 17}, {12, 14}, {12, 15}, {14, 18}, {15, 19}, {18, 19} };
    protected HiddenDodecahedron() {
        vertices   = dodecaVertices;
        faces      = dodecaFaces;
        edges      = dodecaEdges;
    }
}
