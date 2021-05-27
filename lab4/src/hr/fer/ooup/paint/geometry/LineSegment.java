package hr.fer.ooup.paint.geometry;

import hr.fer.ooup.paint.render.AbstractGraphicalObject;
import hr.fer.ooup.paint.render.IGraphicalObject;
import hr.fer.ooup.paint.render.IRenderer;

public class LineSegment extends AbstractGraphicalObject {

    private Point start;
    private Point end;

    public LineSegment() {
        super(new Point[] {new Point(0,0), new Point(100, 100)});
        this.start = new Point(0,0);
        this.end = new Point(50, 50);
    }

    public LineSegment(Point p1, Point p2) {
        super(new Point[] {p1, p2});
        this.start = p1;
        this.end = p2;
    }

    @Override
    public void translate(Point delta) {
        this.start = this.start.translate(delta);
        this.end = this.end.translate(delta);
    }


    @Override
    public Rectangle getBoundingBox() {
        return null;
    }

    @Override
    public double selectionDistance(Point mousePoint) {
        return 0;
    }

    @Override
    public void render(IRenderer r) {
        r.drawLine(this.start, this.end);
    }

    @Override
    public String getShapeName() {
        return "Linija";
    }

    @Override
    public IGraphicalObject duplicate() {
        return new LineSegment(this.start, this.end);
    }
}
