package hr.fer.ooup.paint.geometry;

public class GeometryUtil {
    public static double distanceFromPoint(Point point1, Point point2) {
        return Math.abs(Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2)
                + Math.pow((point2.getY() - point1.getY()), 2)));
    }

    public static double distanceFromLineSegment(Point s, Point e, Point p) {
        return Math.abs((e.getX() - s.getX())*(s.getY() - p.getY()) - (s.getX()-p.getX())*(e.getY()-s.getY()))
                / distanceFromPoint(s, e);
    }
}
