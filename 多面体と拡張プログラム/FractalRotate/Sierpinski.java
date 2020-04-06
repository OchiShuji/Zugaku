public class Sierpinski extends FractalObject {
    protected Sierpinski(int times) {
        super(times);

        primitive = new Tetrahedron();
        int nv = primitive.vertices();
        s = 1.0 / 2.0;
        v = new double[nv][3];
        for (int i = 0; i < nv; i ++)
          for (int j = 0; j < 3; j++)
            v[i][j] = primitive.vertex(i, j) * (1.0 - s);
    }
}