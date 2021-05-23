package hr.fer.ooup.paint;

import jdk.jshell.spi.ExecutionControl;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public Point translate(Point dp) {
        // vraća NOVU točku translatiranu za argument tj. THIS+DP...
        return null;
    }

    public Point difference(Point p) {
        // vraća NOVU točku koja predstavlja razliku THIS-P...
        return null;
    }
}
