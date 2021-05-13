package hr.fer.ooup.texteditor;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Window extends JFrame {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics = (Graphics2D) g;
        Line2D lineHorizontal = new Line2D.Float(0, 150, 300, 150);
        graphics.draw(lineHorizontal);

        Line2D lineVertical = new Line2D.Float(150, 0, 150, 300);
        graphics.draw(lineVertical);

    }
}
