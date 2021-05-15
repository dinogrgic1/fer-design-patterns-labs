package hr.fer.ooup.texteditor;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class TextEditorModel {
    private List<String> lines;
    private LocationRange selectionRange;
    private CursorObserver observer;

    private Location cursorLocation;

    TextEditorModel(String input) {
        cursorLocation = new Location(0, 0);
        lines = Arrays.asList(input.split("\n"));
    }

    public List<String> getLines() {
        return this.lines;
    }

    ListIterator<String> allLines() {
        return lines.listIterator();
    }

    ListIterator<String> linesRange(int idx1, int idx2) {
        List<String> tmp = lines.subList(idx1, idx2);
        return tmp.listIterator();
    }

    void moveCursorLeft() {
        Location l = cursorLocation;
        if (l.x > 0)
            l.x--;
        observer.updateCursorLocation(l);
    }

    void moveCursorRight() {
        Location l = cursorLocation;
        l.x++;
        observer.updateCursorLocation(l);
    }

    void moveCursorUp() {
        Location l = cursorLocation;
        if (l.y > 0)
            l.y--;
        observer.updateCursorLocation(l);
    }

    void moveCursorDown() {
        Location l = cursorLocation;
        l.y++;
        observer.updateCursorLocation(l);
    }

    public void setObserver(CursorObserver observer) {
        if (this.observer == null) {
            this.observer = observer;
        }
    }

    public void removeObserver() {
        this.observer = null;
    }

    public void setCursorLocation(Location cursorLocation) {
        this.cursorLocation = cursorLocation;
    }

    public Location getCursorLocation() {
        return this.cursorLocation;
    }
}
