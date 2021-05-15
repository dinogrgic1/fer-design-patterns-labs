package hr.fer.ooup.texteditor;

public class Location {
    public Integer x;
    public Integer y;

    Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
