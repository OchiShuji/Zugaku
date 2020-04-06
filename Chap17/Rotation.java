public interface Rotation {
  public void setMatrix(double[] matrix, double[] offset);
                                              // OpenGL行列の設定
  public Rotation rotAroundAxis(double angle, double x, double y, double z);
}                                             // 軸回りの回転
