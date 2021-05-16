package hr.fer.ooup.texteditor;

public class LocationRange {
    Location start;
    Location end;

    LocationRange(Location s, Location e) {
        if (isBigger(s, e)) {
            Location temp = s;
            s = e;
            e = temp;
        }
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return String.format("LocationRange{start=%s, end=%s}", start, end);
    }

    public Boolean inRange(Location loc) {
        if (loc.y >= start.y && loc.y <= end.y) {
            if (end.y == start.y) {
                return loc.x >= start.x && loc.x < end.x;
            }
            if (loc.y == end.y) {
                return loc.x < end.x;
            } else if (loc.y == start.y) {
                return loc.x >= start.x;
            } else {
                return true;
            }
        }
        return false;
    }

    private static Boolean isBigger(Location lr1, Location lr2) {
        if (lr2.y > lr1.y) {
            return false;
        } else if (lr2.y == lr1.y) {
            return lr2.x < lr1.x;
        } else {
            return true;
        }
    }
}
