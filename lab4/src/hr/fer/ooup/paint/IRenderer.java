package hr.fer.ooup.paint;

public interface IRenderer {
    void drawLine(Point s, Point e);
    void fillPolygon(Point[] points);
}
