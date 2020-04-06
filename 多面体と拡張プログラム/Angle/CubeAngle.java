public class CubeAngle extends ObjectAngle {
  public static void main(String[] args) {
    if (args.length > 0 && args.length < 4)   // 投影法指定時
      (new CubeAngle("CubeAngle", args, 0)).showFrame();
    else                                      // 標準の投影法
      (new CubeAngle("CubeAngle")).showFrame();
  }

  protected CubeAngle(String name) {          // コンストラクタ
    super(name);                              // 上位コンストラクタの起動
    object = new Cube();                      // 描画立体の登録
  }

  protected CubeAngle(String name, String[] args, int offset) {
    super(name, args, offset);                // 上位コンストラクタの起動
    object = new Cube();                      // 描画立体の登録
  }
}
