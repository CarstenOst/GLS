package main.java.graphics;

import java.awt.*;
import javax.swing.*;

public class DrawingCanvas extends JComponent {

    private int width;
    private int height;
    private SnowStorm ss1;

    public DrawingCanvas(int w, int h){
        width = w;
        height = h;
        ss1 = new SnowStorm();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        ss1.drawSnowStorm(g2d);


    }
}