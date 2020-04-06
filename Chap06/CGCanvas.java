import java.awt.*;
import java.awt.event.*;

public abstract class CGCanvas extends Canvas {
  private Frame f;                            // Frameオブジェクト
  private int width = 600;                    // Canvasの幅
  private int height = 600;                   // Canvasの高さ
  private int originX = 300;                  // 原点位置のx座標
  private int originY = 299;                  // 原点位置のy座標
  protected double range = 2.0;               // 表示空間の広さ(長さ)
  protected double scale = width/range;       // Canvasへの拡大縮小率
  protected int markerSize = 5;               // マーカ(小四角形)の大きさ

  protected CGCanvas(String name) {           // コンストラクタ
    super();                                  // Canvasコンストラクタの実行
    setSize(width, height);                   // 幅と高さの設定
    setBackground(Color.white);               // 背景色の設定(白)
    setForeground(Color.black);               // 描画色の設定(黒)

    f = new Frame(name);                      // Frameの作成
    f.add(this);                              // FrameにCanvaを登録
    f.pack();                                 // 配置とサイズの確定
    f.addWindowListener(new WindowAdapter() { // 無名オブジェクト作成
      public void windowClosing(WindowEvent e) {
        System.exit(0);                       // ウィンドウ閉鎖で終了
      }
    });
  }
  protected void showFrame() {
    f.setVisible(true);                       // Frameの表示
  }
  public void setOrigin(int x, int y) {       // 原点位置の設定
    originX = x;
    originY = y;
  }
  public void setRange(double r) {            // 仮想表示空間の設定
    Dimension d = getSize();                  // Canvasサイズの獲得
    width = d.width;
    height = d.height;
    range = r;                                // 表示領域の設定
    scale = Math.min(width, height) / range;  // 拡大縮小率の変更
  }                                       
  public void drawString(Graphics g, Vector2D pos, String message) {
    g.drawString(message, x(pos), y(pos));    // 文字列の描画
  }
  public void drawLine(Graphics g, Vector2D from, Vector2D to) {
    g.drawLine(x(from), y(from), x(to), y(to)); // 線分の描画
  }
  public void drawCircle(Graphics g, Vector2D point, double radius) {
    int dr = (int) (radius * scale);          // 円の描画
    g.drawOval(x(point) - dr, y(point) - dr, dr * 2, dr * 2);
  }
  public void drawPolyline(Graphics g, Vector2D[] points) {
    int[] x = new int[points.length];         // 折れ線の描画
    int[] y = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      x[i] = x(points[i]);
      y[i] = y(points[i]);
    }
    g.drawPolyline(x, y, points.length);
  }
  public void drawPolygon(Graphics g, Vector2D[] points) {
    int[] x = new int[points.length];         // 多角形(辺)の描画
    int[] y = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      x[i] = x(points[i]);
      y[i] = y(points[i]);
    }
    g.drawPolygon(x, y, points.length);
  }
  public void fillPolygon(Graphics g, Vector2D[] points) {
    int[] x = new int[points.length];         // 多角形(内部)の描画
    int[] y = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      x[i] = x(points[i]);
      y[i] = y(points[i]);
    }
    g.fillPolygon(x, y, points.length);
  }
  public void fillMarker(Graphics g, Vector2D point) {
    g.fillRect(x(point) - markerSize / 2, y(point) - markerSize / 2,
        markerSize, markerSize);              // マーカ(小四角形)の描画
  }
  public Vector2D point(int x, int y) {
    return new Vector2D((x - originX) / scale, (originY - y) / scale);
  }                                 // Canvas上の位置から表示空間への変換 
  protected final int x(Vector2D point) {
    return (int) (scale * point.x()) + originX;
  }                             // 表示空間からCanvas上の位置のx座標へ変換
  protected final int y(Vector2D point) {
    return -(int) (scale * point.y()) + originY;
  }                             // 表示空間からCanvas上の位置のy座標へ変換
  protected final boolean inside(Vector2D point) {
    int x = x(point);
    if (x < 0 || x >= width)
      return false;
    int y = y(point);
    if (y < 0 || y >= height)
      return false;
    return true;
  }                                     // 表示空間の内外判定(曲線描画用)
  
  public void fillCircle(Graphics g, Vector2D point, double radius) {
    int dr = (int) (radius * scale);          
    g.fillOval(x(point) - dr, y(point) - dr, dr * 2, dr * 2);
  }
}
