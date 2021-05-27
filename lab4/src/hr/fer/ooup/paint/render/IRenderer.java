package hr.fer.ooup.paint.render;

import hr.fer.ooup.paint.geometry.Point;

public interface IRenderer {
    void drawLine(Point s, Point e);
    void fillPolygon(Point[] points);
}
