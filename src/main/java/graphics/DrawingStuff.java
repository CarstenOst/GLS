package main.java.graphics;

import javax.swing.*;

public class DrawingStuff {

    public static void main(String[] args){
    int w = 500;
    int h = 500;
    JFrame f = new JFrame();
    DrawingCanvas dc = new DrawingCanvas(w,h);
    f.setSize(w, h);
    f.setTitle("Drawing Stuff");
    f.add(dc);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);

    }
}
