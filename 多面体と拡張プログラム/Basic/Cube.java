// 正六面体（立方体）
// 稜線長       2.0
// 外接球の半径 sqrt(3.0)
public class Cube extends Polyhedron {
  private static final float[][] cubeVertices =   // 8頂点座標値 
  { { -1.0f, -1.0f, -1.0f }, {  1.0f, -1.0f, -1.0f }, { 1.0f,  1.0f, -1.0f },
    { -1.0f,  1.0f, -1.0f }, { -1.0f, -1.0f,  1.0f }, { 1.0f, -1.0f,  1.0f },
    {  1.0f,  1.0f,  1.0f }, { -1.0f,  1.0f,  1.0f } };

  private static final int[][] cubeFaces =        // 6面の頂点番号列
  { { 1, 2, 6, 5 }, { 2, 3, 7, 6 }, { 4, 5, 6, 7 }, { 0, 4, 7, 3 },
    { 0, 1, 5, 4 }, { 0, 3, 2, 1 } };

  private static final int[][] cubeEdges =        // 12稜線の頂点番号列
  { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 4 }, { 1, 5 }, { 2, 6 },
    { 3, 7 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 } };

  private static final float[][] cubeFaceColors = // 6面の描画色
  { { 0.0f, 1.0f, 1.0f }, { 1.0f, 0.0f, 1.0f }, { 1.0f, 1.0f, 0.0f },
    { 0.0f, 0.5f, 0.5f }, { 0.5f, 0.0f, 0.5f }, { 0.5f, 0.5f, 0.0f } };

  protected Cube() {
    vertices   = cubeVertices;
    faces      = cubeFaces;
    edges      = cubeEdges;
    faceColors = cubeFaceColors;
  }
}
