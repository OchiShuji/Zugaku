public class CheckVM {
  public static void main(String[] args) {    // Vector2D, Matrix2X2の確認
    Vector2D vec0 = new Vector2D(0, 0);       // Vector2D (0, 0)
    Vector2D vec1 = new Vector2D(1, 1);       // Vector2D (1, 1)
    Vector2D vec2 = new Vector2D(3, 4);       // Vector2D (3, 4)
    Matrix2X2 rot = Matrix2X2.rotate(Math.PI/2.0); // Matrix2X2 PI/2の回転
    Matrix2X2 inv = Matrix2X2.rotate(-Math.PI/2.0);// Matrix2X2 -PI/2の回転
    Matrix2X2 scl = Matrix2X2.scale(2.0);          // Matrix2X2 2倍の拡大
    
    System.out.println("|" + vec2 + "| = " + vec2.norm());
                                              // (3, 4) のノルム
    System.out.println(vec1 + " + " + vec2 + " = " + vec1.add(vec2));
                                              // (1, 1) + (3, 4)
    System.out.println(vec2 + " - " + vec1 + " = " + vec2.subtract(vec1));
                                              // (3, 4) - (1, 1)
    System.out.println(vec2 + " * 2.0 = " + vec2.scale(2.0));
                                              // (3, 4) * 2
    System.out.println("Normalize " + vec0 + " = " + vec0.normalize());
                                              // (0, 0) の正規化
    System.out.println("Normalize " + vec2 + " = " + vec2.normalize());
                                              // (3, 4) の正規化
    System.out.println("Rotate    " + vec1 + " = " + rot.apply(vec1));
                                              // (1, 1) の(PI/2)回転
    System.out.println("Scale&Rot " + vec1 + " = " +
                       scl.multiply(rot).apply(vec1));
                                           // (1, 1) の(PI/2)回転 & 2倍拡大
    System.out.println("Inv&Rot   " + vec2 + " = " +
                       inv.multiply(rot).apply(vec2));
  }                                  // (3, 4) の (PI/2)回転 & (-PI/2) 回転
}