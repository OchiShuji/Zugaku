import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import javax.media.opengl.awt.*;

public class Lines extends GLCanvas implements GLEventListener {
  public static void main(String[] args) {    // Linesオブジェクトの作成
    (new Lines("Lines")).showFrame();
  }

  protected Frame f;                          // Frameオブジェクト
  protected GL2 gl;                           // GL2オブジェクト

  protected static final int width = 600;     // GLCanvasの幅
  protected static final int height = 600;    // GLCanvasの高さ
  protected static final int[][] points =     // 直線群の終端点座標値
  {{10, 599}, {30, 599}, {75, 599}, {150, 599}, {300, 599}, {599, 599},
    {599, 300}, {599, 150}, {599, 75}, {599, 30}, {599, 10}
  };

  protected Lines() {
    super();                                  // GLCanvasのコンストラクタ実行
  }

  protected Lines(String name) {
    super();                                  // GLCanvasのコンストラクタ実行
    setSize(width, height);                   // 幅と高さの設定
    addGLEventListener(this);                 // GLイベント登録

    f = new Frame(name);                      // Frameの作成
    f.add(this);                              // FrameにGLCanvasを登録
    f.pack();                                 // 配置とサイズの確定
    f.addWindowListener(new WindowAdapter() { // 無名オブジェクトの作成
      public void windowClosing(WindowEvent e) {
        System.exit(0);                       // ウィンドウ閉鎖で終了
      }
    });
  }

  protected void showFrame() {
    f.setVisible(true);                       // Frameの表示
  }

  public void init(GLAutoDrawable drawable) { // 初期化
    gl = drawable.getGL().getGL2();           // GLオブジェクトの取得
    GLU glu = new GLU();                      // GLUオブジェクトの取得
    gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);  // 背景色の設定(白)
    gl.glColor4f(0.0f, 0.0f, 0.0f, 1.0f);     // 描画色の設定(黒)

    gl.glViewport(0, 0, width, height);       // 描画領域の指定 
    gl.glMatrixMode(GL2.GL_PROJECTION);       // 投影変換行列
    gl.glLoadIdentity();                      // 恒等行列の設定
    glu.gluOrtho2D(-0.5, width-0.5, -0.5, height-0.5);
                                              // 2次元直投影の指定
    gl.glMatrixMode(GL2.GL_MODELVIEW);        // モデル変換行列
    gl.glLoadIdentity();                      // 恒等行列の設定
  }

  public void display(GLAutoDrawable drawable) { // 描画要求時
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);      // バッファクリア(画面消去)
    gl.glBegin(GL2.GL_LINES);                 // 直線群の描画開始
    for (int i = 0; i < points.length; i++) { // 終端点の数だけ直線描画
      gl.glVertex2i(0, 0);                    // 原点→終端点
      gl.glVertex2i(points[i][0], points[i][1]);
    }
    gl.glEnd();                               // 直線群の描画終了
    gl.glFlush();                             // 描画要求送信
  }

  public void reshape(GLAutoDrawable drawable, // ウィンドウサイズ変更時 
      int x, int y, int width, int height) {
  }

  public void dispose(GLAutoDrawable drawable) { // ウィンドウ消去時
  }
}
