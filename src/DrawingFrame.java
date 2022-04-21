import javax.swing.*;
import java.awt.*;

import java.awt.geom.Rectangle2D;

public class DrawingFrame extends JComponent {
    public DrawingFrame(){
    }

    protected void paintComponent(Graphics g){
        int x = 0;
        int y = 0;
        int wi = 1920;
        int he = 540;

        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(x, y, wi, he);
        g2d.setColor(new Color(100, 140,255));
        g2d.fill(r);

        Rectangle2D.Double r2 = new Rectangle2D.Double(x, y + he, wi, he);
        g2d.setColor(Color.yellow);

        g2d.fill(r2);


    }
}

// Vi får svar på eksamen i mårra :)
