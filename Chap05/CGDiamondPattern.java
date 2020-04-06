import java.awt.*;
import java.awt.event.*;

public class CGDiamondPattern extends CGCircle {
    public static void main(String[] args) {
        if (args.length == 0)
          System.err.println("Usage: java CGDiamondPattern #");
        else
          radius = 0.8;
          (new CGDiamondPattern("CGDiamondPattern", Integer.parseInt(args[0]))).showFrame();
    }

    
    protected CGDiamondPattern(String name, int numberOfPoints) {
      super(name, numberOfPoints);
      setOrigin(360, 299);
  }

  public void paint(Graphics g) {
      super.paint(g);
      for (int i = 0; i < points.length; i++) {
        for (int j = i + 2; j < points.length; j++) {
          drawLine(g, points[i], points[j]);
        }
      }
  }
}