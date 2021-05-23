package hr.fer.ooup.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Canvas extends JComponent implements IRenderer{

    Canvas() {
        setBackground(Color.WHITE);
        setMinimumSize(new Dimension(600, 600));
    }

    @Override
    public void paintComponent(Graphics g) {
        drawLine(new Point(0, 0), new Point(100, 300));
    }

    @Override
    public void drawLine(Point s, Point e) {
        Graphics2D g2D = (Graphics2D) this.getGraphics();
        g2D.setColor(Color.blue);
        g2D.draw(new Line2D.Float(s.getX(), s.getY(), e.getX(), e.getY()));
    }

    @Override
    public void fillPolygon(Point[] points) {

    }
}
