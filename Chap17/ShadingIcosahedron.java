// 正二十面体
// 稜線長       2.0
// 外接球の半径 sqrt(PHI * sqrt(5.0))
// 黄金比 (PHI) (1.0 + sqrt(5.0)) / 2.0
public class ShadingIcosahedron extends ShadingPolyhedron {
  public  static final float PHI  = (float)((1.0 + Math.sqrt(5.0))/2.0);
  public  static final float R_CS = (float)Math.sqrt(PHI * Math.sqrt(5.0));
  private static final float[][] icosaVertices =   // 12頂点座標値 
  { {  0.0f,  1.0f,   PHI }, {  0.0f, -1.0f,   PHI }, {  0.0f, -1.0f,  -PHI },
    {  0.0f,  1.0f,  -PHI }, {   PHI,  0.0f,  1.0f }, {   PHI,  0.0f, -1.0f }, 
    {  -PHI,  0.0f, -1.0f }, {  -PHI,  0.0f,  1.0f }, {  1.0f,   PHI,  0.0f },
    { -1.0f,   PHI,  0.0f }, { -1.0f,  -PHI,  0.0f }, {  1.0f,  -PHI,  0.0f } };
  private static final int[][] icosaFaces =        // 20面の頂点番号列
  { { 0,  1,  4 }, { 0,  4, 8 }, { 0,  8, 9 }, { 0, 9,  7 }, { 0,  7,  1 },
    { 1, 10, 11 }, { 1, 11, 4 }, { 4, 11, 5 }, { 4, 5,  8 }, { 8,  5,  3 },
    { 8,  3,  9 }, { 9,  3, 6 }, { 9,  6, 7 }, { 7, 6, 10 }, { 7, 10,  1 },
    { 2, 10,  6 }, { 2,  6, 3 }, { 2,  3, 5 }, { 2, 5, 11 }, { 2, 11, 10 } };

  private static final float[] icosaDiffuse  = { 0.8f, 0.3f, 0.8f, 1.0f };
                                              // 反射特性の拡散成分
  private static final float[] icosaSpecular = { 0.9f, 0.9f, 0.9f, 1.0f };
                                              // 反射特性の鏡面成分
  private static final float icosaShininess  = 100.0f;
                                              // 鏡面反射の減衰係数
  protected ShadingIcosahedron() {
    vertices    = icosaVertices;
    faces       = icosaFaces;
    diffuse     = icosaDiffuse;
    specular    = icosaSpecular;
    shininess   = icosaShininess;
    faceNormals = new float[faces.length][3];
    for (int i = 0; i <faces.length; i++) {   // 各面の法線ベクトルの計算
      faceNormals[i] = normal(vertices[faces[i][0]], vertices[faces[i][1]], 
                              vertices[faces[i][2]]);
    }
  }

  protected float[] normal(float[] pnt0, float[] pnt1, float[] pnt2) {
    return crossProduct(subtract(pnt1, pnt0), subtract(pnt2, pnt0));
  }                        // 法線ベクトルの計算 - 2辺の方向ベクトルの外積

  private float[] subtract(float[] vec0, float[] vec1) {
    float[] answer = new float[3];            // ベクトルの差分計算
    for (int i = 0; i < 3; i++)
      answer[i] = vec0[i] - vec1[i];
    return answer;
  }

  private float[] crossProduct(float[] vec0, float[] vec1) {
    float[] answer = new float[3];            // ベクトルの外積計算
    answer[0] = vec0[1] * vec1[2] - vec0[2] * vec1[1];
    answer[1] = vec0[2] * vec1[0] - vec0[0] * vec1[2];
    answer[2] = vec0[0] * vec1[1] - vec0[1] * vec1[0];
    return answer;
  }
}
