public class ShadingIcosahedronFractal extends FractalObject {
    protected ShadingIcosahedronFractal(int times) {
        super(times);

        primitive = new ShadingIcosahedron();
        int nv = primitive.vertices();
        float phi = (float)(1 + Math.sqrt(5)) / 2;
        s = 1.0 / (1.0 + phi);
        v = new double[nv][3];
        for (int i = 0; i < nv; i ++)
          for (int j = 0; j < 3; j++)
            v[i][j] = primitive.vertex(i, j) * (1.0 - s);
    }
}