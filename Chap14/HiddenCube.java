import javax.media.opengl.*;

public class HiddenCube extends HiddenPolyhedron {
  private static final float[][] cubeVertices =   
  { { -1.0f, -1.0f, -1.0f }, {  1.0f, -1.0f, -1.0f }, { 1.0f,  1.0f, -1.0f },
    { -1.0f,  1.0f, -1.0f }, { -1.0f, -1.0f,  1.0f }, { 1.0f, -1.0f,  1.0f },
    {  1.0f,  1.0f,  1.0f }, { -1.0f,  1.0f,  1.0f } };

  private static final int[][] cubeEdges =       
  { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 4 }, { 1, 5 }, { 2, 6 },
    { 3, 7 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 } };
  
  private static final int[][] cubeFaces =        
  { { 1, 2, 6, 5 }, { 2, 3, 7, 6 }, { 4, 5, 6, 7 }, { 0, 4, 7, 3 },
    { 0, 1, 5, 4 }, { 0, 3, 2, 1 } };

  protected HiddenCube() {
      vertices   = cubeVertices;
      faces      = cubeFaces;
      edges      = cubeEdges;   
  }
}
