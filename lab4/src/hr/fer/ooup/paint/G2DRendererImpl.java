package hr.fer.ooup.paint;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Arrays;

public class G2DRendererImpl implements IRenderer  {

    private Graphics2D g2d;

    public G2DRendererImpl(Graphics2D g2d) {
        this.g2d = g2d;
    }

    @Override
    public void drawLine(Point s, Point e) {
        this.g2d.setColor(Color.blue);
        this.g2d.draw(new Line2D.Double(s.getX(), s.getY(), e.getX(), e.getY()));
    }

    @Override
    public void fillPolygon(Point[] points) {
        int[] xValue =  Arrays.stream(points).mapToInt(Point::getX).toArray();
        int[] yValue = Arrays.stream(points).mapToInt(Point::getY).toArray();

        this.g2d.setColor(Color.red);
        this.g2d.drawPolygon(xValue, yValue, xValue.length);

        this.g2d.setColor(Color.blue);
        this.g2d.fillPolygon(xValue, yValue, xValue.length);
    }
}
