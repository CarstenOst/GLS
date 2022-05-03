package main.java.graphics;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class DrawingCanvas extends JComponent {

    private int width;
    private int height;

    public DrawingCanvas(int w, int h){
        width = w;
        height = h;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D.Double r = new Rectangle2D.Double(50,70,100,40);

        g2d.setColor(Color.blue);

        g2d.fill(r);
    }
}