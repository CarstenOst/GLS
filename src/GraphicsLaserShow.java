import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Carsten Østergaard
 * @version 17.03.2022 V0.0.1
 *
 */

public class GraphicsLaserShow {
    public static void main(String[] args) {
        /*int w = 1920;
        int h = 1080;
        JFrame f = new JFrame();
        DrawingFrame df = new DrawingFrame();
        Eclipse ye = new Eclipse();
        f.getContentPane().setBackground(Color.black);
        f.setSize(w, h);
        f.setTitle("BingBong");
        f.add(df);
        //f.add(ye);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);*/







        Effekt ef;

        ef = new Effekt();
        ef.display();
        ef.defaultPrint();

        ef = new Strobe();
        ef.display();
        ef.defaultPrint();

        ef = new FargetStrobe();
        ef.display();
        ef.defaultPrint();
    }
}
