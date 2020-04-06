import java.awt.*;
import java.awt.event.*;

public class Lines extends Canvas {
  public static void main(String[] args) {
    new Lines("Lines");                       // Linesオブジェクトの作成
  }

  private static final int width = 600;       // Canvasの幅
  private static final int height = 600;      // Canvasの高さ
  protected static final int[][] points =     // 直線群の終端点座標値
  {{10, 599}, {30, 599}, {75, 599}, {150, 599}, {300, 599}, {599, 599},
    {599, 300}, {599, 150}, {599, 75}, {599, 30}, {599, 10}
  };

  protected Lines(String name) {
    super();                                  // Canvasのコンストラクタ実行
    setSize(width, height);                   // 幅と高さの設定
    setBackground(Color.white);               // 背景色の設定(白)
    setForeground(Color.black);               // 描画色の設定(黒)

    Frame f = new Frame(name);                // Frameの作成
    f.add(this);                              // FrameにCanvasを登録
    f.pack();                                 // 配置とサイズの確定
    f.addWindowListener(new WindowAdapter() { // 無名オブジェクト作成
      public void windowClosing(WindowEvent e) {
        System.exit(0);                       // ウィンドウ閉鎖で終了
      }
    });
    f.setVisible(true);                       // Frameの表示
  }
    
  public void paint(Graphics g) {
    for (int i = 0; i < points.length; i++) { // 終端点の数だけ直線描画
      g.drawLine(0, 0, points[i][0], points[i][1]);
    }                                         // 原点→終端点
  }
}
