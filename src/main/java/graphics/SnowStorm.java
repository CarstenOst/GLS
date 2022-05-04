package main.java.graphics;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SnowStorm {

    private double x, y, maxSize, minSize, color;

    private int speed, index = 0, count = 0;

    public void drawSnowStorm(Graphics2D g2d){

        Ellipse2D.Double e1 = new Ellipse2D.Double(200,75,100,100);
        g2d.setColor(Color.blue);
        g2d.fill(e1);
    }

}
