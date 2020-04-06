public class CubeShade extends ObjectShade {
  public static void main(String[] args) {
    (new CubeShade("CubeShade")).showFrame(); // CubeShadeオブジェクトの生成
  }

  protected CubeShade(String name) {
    super(name);                           // ObjectShadeコンストラクタの実行
    object = new ShadingCube();               // 描画立体の登録
  }
}
