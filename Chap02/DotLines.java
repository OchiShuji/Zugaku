import java.awt.*;

public class DotLines extends Lines {
  public static void main(String[] args) {
    new DotLines("DotLines");                 // DotLinesオブジェクトの作成
  }

  private DotLines(String name) {
    super(name);                              // Linesのコンストラクタ実行
  }
    
  public void paint(Graphics g) {
    for (int i = 0; i < points.length; i++) { // 終端点数だけ直線描画
      if (points[i][0] >= points[i][1]) {     // x >= y (横長の直線)
        int n = points[i][0];                 // 表示ピクセルの個数: n = x
        double d = ((double)points[i][1])/n;  // 1ピクセルごとの差分
        for (int x = 0; x <= n; x++) {        // ピクセル描画 (n+1)回
          g.fillRect(x, (int)(d*x+0.5), 1, 1);//ピクセルの描画
        }
      }
      else {                                  // x < y (縦長の直線)
        int n = points[i][1];                 // 表示ピクセルの個数: n = y
        double d = ((double)points[i][0])/n;  // 1ピクセルごとの差分
        for (int y = 0; y <= n; y++) {        // ピクセル描画 (n+1)回
          g.fillRect((int)(d*y+0.5), y, 1, 1);// ピクセルの描画
        }
      }
    }
  }
}
