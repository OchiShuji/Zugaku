import java.awt.*;
import java.awt.event.*;

public class CrossLine extends Canvas {
  public static void main(String[] args) {
    if (args.length == 0) {                   // コマンド引数の確認
      System.err.println("Usage: java CrossLine <message>");
    }
    else {
      new CrossLine(args);                    // CrossLineオブジェクトの作成
    }
  }

  private static final int width = 400;       // Canvasの幅
  private static final int height = 300;      // Canvasの高さ
  private static String message = null;       // 描画文字列

  protected CrossLine(String[] words) {
    super();                                  // Canvasのコンストラクタ実行
    setSize(width, height);                   // 幅と高さの設定
    setBackground(Color.white);               // 背景色の設定(白)
    setForeground(Color.black);               // 描画色の設定(黒)

    message = words[0];                       // 描画文字列の設定
    Frame f = new Frame("CrossLine");         // Frameの作成
    f.add(this);                              // FrameにCanvasを登録
    f.pack();                                 // 配置とサイズの確定
    f.addWindowListener(new WindowAdapter() { // 無名オブジェクトの作成
      public void windowClosing(WindowEvent e) {
        System.exit(0);                       // ウィンドウ閉鎖で終了
      }
    });
    f.setVisible(true);                       // Frameの表示
  }
    
  public void paint(Graphics g) {
    g.drawLine(0, 0, width-1, height-1);      // 直線: 左上→右下
    g.drawLine(0, height-1, width-1, 0);      // 直線: 左下→右上
    g.drawString(message, width/2, height/2); // 文字列: 中央付近
  }
}
