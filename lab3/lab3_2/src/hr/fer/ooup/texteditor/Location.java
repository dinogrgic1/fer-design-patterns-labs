package hr.fer.ooup.texteditor;

public class Location {
    public Integer x;
    public Integer y;

    Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    Location(Location l) {
        this.x = l.x;
        this.y = l.y;
    }

    @Override
    public String toString() {
        return String.format("Location{x=%s, y=%s}", x, y);
    }
}
