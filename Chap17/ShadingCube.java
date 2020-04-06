// 正六面体（立方体）
// 稜線長       2.0
// 外接球の半径 sqrt(3.0)
public class ShadingCube extends ShadingPolyhedron {
  private static final float[][] cubeVertices =    // 8頂点座標値 
  { { -1.0f, -1.0f, -1.0f }, {  1.0f, -1.0f, -1.0f }, { 1.0f,  1.0f, -1.0f },
    { -1.0f,  1.0f, -1.0f }, { -1.0f, -1.0f,  1.0f }, { 1.0f, -1.0f,  1.0f },
    {  1.0f,  1.0f,  1.0f }, { -1.0f,  1.0f,  1.0f } };
  private static final int[][] cubeFaces =         // 6面の頂点番号列
  { { 1, 2, 6, 5 }, { 2, 3, 7, 6 }, { 4, 5, 6, 7 }, { 0, 4, 7, 3 },
    { 0, 1, 5, 4 }, { 0, 3, 2, 1 } };
  private static final float[][] cubeFaceNormals = // 6面の法線ベクトル
  { {  1.0f, 0.0f, 0.0f }, { 0.0f,  1.0f, 0.0f }, { 0.0f, 0.0f,  1.0f },
    { -1.0f, 0.0f, 0.0f }, { 0.0f, -1.0f, 0.0f }, { 0.0f, 0.0f, -1.0f } };
  private static final int[][] cubeEdges =        // 12稜線の頂点番号列
  { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 4 }, { 1, 5 }, { 2, 6 },
    { 3, 7 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 } };
  private static final float[] cubeDiffuse  = { 0.8f, 0.8f, 0.2f, 1.0f };
                                              // 反射特性の拡散成分
  private static final float[] cubeSpecular = { 0.9f, 0.9f, 0.9f, 1.0f };
                                              // 反射特性の鏡面成分
  private static final float cubeShininess  = 100.0f;
                                              // 鏡面反射の減衰係数

  protected ShadingCube() {
    vertices    = cubeVertices;
    faces       = cubeFaces;
    faceNormals = cubeFaceNormals;
    edges       = cubeEdges;
    diffuse     = cubeDiffuse;
    specular    = cubeSpecular;
    shininess   = cubeShininess;
  }
}
