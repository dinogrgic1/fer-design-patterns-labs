package hr.fer.ooup.paint;

public class Oval extends AbstractGraphicalObject{

    private Point center;
    private double A;
    private double B;

    protected Oval() {
        super(new Point[]{new Point(10, 0), new Point(0, 10)});
        this.center = new Point(5, 5);
        this.A = this.B = 10;
    }

    protected Oval(Point right, Point down) {
        super(new Point[] {right, down});
        this.center = new Point(down.getX(), right.getY());
        this.B = Math.abs(down.getY() - this.center.getY());
        this.A = Math.abs(right.getX() - this.center.getX());
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
        Point[] p = new Point[361];
        for (int i = 0; i <= 360; i++) {
            double x, y;
            x = A * Math.sin(Math.toRadians(i));
            y = B * Math.cos(Math.toRadians(i));
            p[i] = new Point(this.center.getX() + (int)x, this.center.getY() + (int)y);

        }
        r.fillPolygon(p);
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
