import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import javax.media.opengl.awt.*;

public abstract class ObjectAngle extends GLCanvas
                                  implements GLEventListener {
  private   Frame f;                          // Frameオブジェクト
  protected GL2 gl;                           // GLオブジェクト
  protected GLU glu;                          // GLUオブジェクト
  protected double fieldOfView = 25.0, near = 1.0, far = 20.0;
                    // カメラ(透視投影)のパラメタ 画角, 前方/後方クリッピング面
  protected float depth = -10.0f;             // 平行移動量
  protected float rotx = 20.0f, roty = -30.0f, rotz = 0.0f;
                                              // x軸,y軸,z軸回りの回転角 
  protected DisplayObject object;             // 具体的な描画命令
  protected int   objectID;                   // ディスプレイリスト番号

  protected ObjectAngle(String name) {        // コンストラクタ
    super();                                  // GLCanvasのコンストラクタ実行
    setSize(500, 500);                        // 幅と高さの設定
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

  protected ObjectAngle(String name, String[] args, int offset) {
    this(name);                               // 標準コンストラクタの起動
    switch (args.length - offset) {
    case 1:                                   // 画角指定
      fieldOfView = Double.parseDouble(args[0+offset]); break;
    case 2:                                   // クリッピング面指定
      near = Double.parseDouble(args[0+offset]);
      far = Double.parseDouble(args[1+offset]);  break;
    case 3:                                   // 回転角指定
      rotx = Float.parseFloat(args[0+offset]); // x軸回り
      roty = Float.parseFloat(args[1+offset]); // y軸回り
      rotz = Float.parseFloat(args[2+offset]); // z軸回り
    }
  }
    
  protected void showFrame() {
    f.setVisible(true);                       // Frameの表示
  }
    
  public void init(GLAutoDrawable drawable) { // 初期化
    baseInit(drawable);                       // 基本機能の初期化
    objectInit();                             // 立体定義(ディスプレイリスト)
  }

  protected void baseInit(GLAutoDrawable drawable) {
    gl = drawable.getGL().getGL2();           // GLオブジェクトの取得
    glu = new GLU();                          // GLUオブジェクト
    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // 背景色
    gl.glEnable(GL2.GL_DEPTH_TEST);           // 奥行テスト利用
    gl.glEnable(GL2.GL_CULL_FACE);            // 背面除去利用
  }
  
  protected void objectInit() {
    objectID = gl.glGenLists(1);              // ディスプレイリスト作成
    gl.glNewList(objectID, GL2.GL_COMPILE);   // 登録開始
    object.display(gl);                       // 描画命令
    gl.glEndList();                           // 登録終了
  }
  
  public void reshape(GLAutoDrawable drawable, // ウィンドウサイズ変更時 
      int x, int y, int w, int h) {
    cameraInit(w, h);                         // カメラ(レンズ)の設定
    positionInit();                           // 初期位置の設定
  }

  protected void cameraInit(int w, int h) {   // カメラ(レンズ)の設定
    double aspect = (double) w / (double) h;  // 縦横比 
    gl.glViewport(0, 0, w, h);                // 描画領域の指定 
    gl.glMatrixMode(GL2.GL_PROJECTION);       // 投影変換行列
    gl.glLoadIdentity();                      // 恒等行列の設定
    glu.gluPerspective(fieldOfView, aspect, near, far);
                                              // 透視投影変換行列作成
    gl.glMatrixMode(GL2.GL_MODELVIEW);        // モデル変換行列
    gl.glLoadIdentity();                      // 恒等行列の設定
  }

  protected void positionInit() {             // 初期位置の設定
    gl.glTranslatef(0.0f, 0.0f, depth);       // 平行移動 (z軸方向)  
  }
  
  public void display(GLAutoDrawable drawable) { // 描画要求時
    setMatrix();                              // 変換行列の設定
    gl.glCallList(objectID);                  // ディスプレイリスト呼出し
    resetMatrix();                            // 変換行列の再設定
  }
  
  protected void setMatrix() {                // 変換行列の設定
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
                                              // バッファクリア(画面消去)
    gl.glPushMatrix();                        // 行列の複写
    gl.glRotatef(rotx, 1.0f, 0.0f, 0.0f);     // 回転 (x軸回り)
    gl.glRotatef(roty, 0.0f, 1.0f, 0.0f);     // 回転 (y軸回り)
    gl.glRotatef(rotz, 0.0f, 0.0f, 1.0f);     // 回転 (z軸回り)
  }

  protected void resetMatrix() {              // 変換行列の再設定
    gl.glPopMatrix();                         // 複写行列の回復
  }

  public void dispose(GLAutoDrawable drawable) { // ウィンドウ消去時
  }
}
