public class ShadingMengerSponge extends FractalObject {
    protected ShadingMengerSponge(int times) {
        super(times);

        primitive = new ShadingCube();
        int nv = primitive.vertices();
        int ne = primitive.edges();
        s = 1.0 / 3.0;
        v = new double[nv+ne][3];
        for (int i = 0; i < nv; i ++)
          for (int j = 0; j < 3; j++)
            v[i][j] = primitive.vertex(i, j) * (1.0 - s);
        for (int i = 0; i < ne; i++)
          for (int j = 0; j < 3; j++)
            v[i+nv][j] = (primitive.edgeVertex(i, 0, j) + primitive.edgeVertex(i, 1, j)) / 2.0 * (1.0 - s);
    }
}