package hr.fer.ooup.paint;

public class Oval extends AbstractGraphicalObject{

    private Point center;

    protected Oval() {
        super(new Point[] {new Point(10,0), new Point(0, 10)});
        this.center = new Point(5,5);
    }

    protected Oval(Point right, Point down) {
        super(new Point[] {right, down});
        this.center = new Point(down.getX() / 2, right.getY() / 2);
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
        return "Oval";
    }

    @Override
    public IGraphicalObject duplicate() {
        return new Oval();
    }
}
