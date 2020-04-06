public class IcosahedronShade extends ObjectShade {
  public static void main(String[] args) {
    (new IcosahedronShade("IcosahedronShade")).showFrame();
  }                                     // IcosahedronShadeオブジェクトの生成

  protected IcosahedronShade(String name) {
    super(name);                           // ObjectShadeコンストラクタの実行
    object = new ShadingIcosahedron();        // 描画立体の登録
  }
}
