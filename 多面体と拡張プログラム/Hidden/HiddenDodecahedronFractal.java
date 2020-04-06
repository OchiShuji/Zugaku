public class HiddenDodecahedronFractal extends FractalObject {
    protected HiddenDodecahedronFractal(int times) {
        super(times);

        primitive = new HiddenDodecahedron();
        int nv = primitive.vertices();
        float phi = (float)((1.0 + Math.sqrt(5)) / 2.0);
        s = 1.0 / (2.0 + phi);
        v = new double[nv][3];
        for (int i = 0; i < nv; i ++)
          for (int j = 0; j < 3; j++)
            v[i][j] = primitive.vertex(i, j) * (1.0 - s);
    }
}