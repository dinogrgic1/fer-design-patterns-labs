package hr.fer.ooup.paint;

public class LineSegment extends AbstractGraphicalObject{

    private Point start;
    private Point end;

    protected LineSegment() {
        super(new Point[] {new Point(0,0), new Point(10, 0)});
        this.start = new Point(0,0);
        this.end = new Point(10, 0);
    }

    protected LineSegment(Point p1, Point p2) {
        super(new Point[] {p1, p2});
        this.start = p1;
        this.end = p2;
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
    public String getShapeName() {
        return "Linija";
    }

    @Override
    public IGraphicalObject duplicate() {
        return new LineSegment(this.start, this.end);
    }
}
