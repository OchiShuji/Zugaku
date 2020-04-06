public class Quaternion implements Rotation {
  private final double s, x, y, z;            // 四元数の成分

  private Quaternion(double s, double x, double y, double z) {
    this.s = s;  this.x = x;  this.y = y;  this.z = z;
  }                                           // コンストラクタ: 成分の初期化

  private Quaternion multiply(Quaternion b) { // 四元数の積
    Quaternion a = this;                      // A(this) × B
    double ns = a.s*b.s - a.x*b.x - a.y*b.y - a.z*b.z;
    double nx = a.s*b.x + a.x*b.s + a.y*b.z - a.z*b.y;
    double ny = a.s*b.y + a.y*b.s + a.z*b.x - a.x*b.z;
    double nz = a.s*b.z + a.z*b.s + a.x*b.y - a.y*b.x;
    return new Quaternion(ns, nx, ny, nz);
  }

  public void setMatrix(double[] matrix, double[] offset) {
                                              // OpenGL行列の設定
    double d = s*s + x*x + y*y + z*z;         // 単位四元数の準備
    matrix[0] = 1 - 2*(y*y + z*z)/d;  matrix[1] = 2*(x*y + s*z)/d;  
    matrix[2] = 2*(x*z - s*y)/d;  matrix[3] = 0.0;
    matrix[4] = 2*(x*y - s*z)/d;  matrix[5] = 1 - 2*(x*x + z*z)/d;
    matrix[6] = 2*(y*z + s*x)/d;  matrix[7]  = 0.0;
    matrix[8] = 2*(x*z + s*y)/d;  matrix[9] = 2*(y*z - s*x)/d;  
    matrix[10] = 1 - 2*(x*x + y*y)/d;  matrix[11] = 0.0;
    matrix[12] = offset[0];  matrix[13] = offset[1];  
    matrix[14] = offset[2];  matrix[15] = 1.0;
  }                                           // OpenGLの行列は列優先
  
  public Rotation rotAroundAxis(double angle, // 軸回りの回転
                                double x, double y, double z) {
    angle *= Math.PI / 180.0;                 // ラジアン単位の回転角
    double r = Math.sin(angle/2.0) / Math.sqrt(x*x + y*y + z*z);
                                              // 軸ベクトルの正規化
    return this.multiply(new Quaternion       // 単位四元数の積
                         (Math.cos(angle/2.0), r*x, r*y, r*z));
  }
  
  public static Quaternion identity() {       // 恒等四元数
    return new Quaternion(1.0, 0.0, 0.0, 0.0);
  }
}
