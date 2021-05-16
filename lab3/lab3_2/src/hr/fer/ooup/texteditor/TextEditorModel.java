package hr.fer.ooup.texteditor;

import java.util.*;

public class TextEditorModel {
    private Vector<String> lines;

    private LocationRange selectionRange;
    private LocationRange latestSelectionRange;

    private CursorObserver observer;
    private TextObserver txtObserver;
    private ClipboardStack clipboardStack;

    private Location cursorLocation;

    TextEditorModel(String input) {
        cursorLocation = new Location(0, 0);
        lines = new Vector<String>(Arrays.asList(input.split("\n")));
    }

    public List<String> getLines() {
        return this.lines;
    }

    ListIterator<String> allLines() {
        return lines.listIterator();
    }

    ListIterator<String> linesRange(int idx1, int idx2) {
        List<String> tmp = lines.subList(idx1, idx2 + 1);
        return tmp.listIterator();
    }

    public void removeObserver() {
        this.observer = null;
    }

    public void setCursorLocation(Location cursorLocation) {
        this.cursorLocation = cursorLocation;
    }

    public void setCursorLocation(Integer x, Integer y) {
        this.cursorLocation = new Location(x, y);
    }

    public Location getCursorLocation() {
        return this.cursorLocation;
    }

    public void setObserver(CursorObserver observer) {
        if (this.observer == null) {
            this.observer = observer;
        }
    }

    void moveCursorLeft() {
        Location l = cursorLocation;
        if (l.x > 0)
            l.x--;
        observer.updateCursorLocation();
    }

    void moveCursorRight() {
        Location l = cursorLocation;
        if (l.x != lines.get(l.y).length())
            l.x++;
        observer.updateCursorLocation();
    }

    void moveCursorUp() {
        Location l = cursorLocation;
        if (l.y > 0)
            l.y--;
        l.x = lines.get(l.y).length();
        observer.updateCursorLocation();
    }

    void moveCursorDown() {
        Location l = cursorLocation;
        if(l.y != lines.size() - 1) {
            l.y++;
            l.x = 0;
        }
        observer.updateCursorLocation();
    }


    public void setTxtObserver(TextObserver observer) {
        if (this.txtObserver == null) {
            this.txtObserver = observer;
        }
    }

    public void removeTxtObserver() {
        this.txtObserver = null;
    }

    void deleteBefore() {
        Location currLocation = cursorLocation;
        String currLine = lines.get(currLocation.y);
        if (currLocation.x == 0) {
            if (currLocation.y != 0) {
                String lastLine = lines.get(currLocation.y - 1);
                lines.set(currLocation.y - 1, lastLine + currLine);
                lines.remove((int) currLocation.y);
                moveCursorUp();
                this.txtObserver.updateText();
            }
        } else {
            String newLine = currLine.substring(0, currLocation.x - 1)
                    + currLine.substring(currLocation.x);
            lines.set(currLocation.y, newLine);
            moveCursorLeft();
            this.txtObserver.updateText();
        }
    }

    void deleteAfter() {
        Location currLocation = cursorLocation;
        String currLine = lines.get(currLocation.y);
        if (currLocation.x < currLine.length()) {
            String newLine = currLine.substring(0, currLocation.x)
                    + currLine.substring(currLocation.x + 1);
            lines.set(currLocation.y, newLine);
            this.txtObserver.updateText();
        }
    }

    void deleteRange(LocationRange r) {
        if (r.start.y == r.end.y) {
            String currLine = lines.get(r.start.y);
            String newLine = currLine.substring(0, r.start.x)
                    + currLine.substring(r.end.x);
            lines.set(r.start.y, newLine);
        } else {
            String currLine = "";
            for (int i = r.start.y + 1; i < r.start.y; i++) {
                currLine += lines.get(i);
                lines.remove((int) i);
            }

            String start = "";
            String end = "";
            if (lines.get(r.start.y).length() != 0 && lines.get(r.start.y).length() != r.start.x) {
                start = lines.get(r.start.y).substring(0, r.start.x);
            }
            if (lines.get(r.end.y).length() != 0 && lines.get(r.start.y).length() != r.end.x) {
                end = lines.get(r.end.y).substring(r.end.x);
            }
            String newLine = start + currLine + end;
            lines.remove((int) r.end.y);
            lines.set(r.start.y, newLine);
        }
        this.setCursorLocation(r.start);
        this.txtObserver.updateText();
    }

    LocationRange getSelectionRange() {
        return this.selectionRange;
    }

    LocationRange getLatestSelectionRange() {
        return this.latestSelectionRange;
    }

    void setSelectionRange(Location start, Location end) {
        selectionRange = new LocationRange(start, end);
    }

    void setLatestSelectionRange() {
        latestSelectionRange = this.selectionRange;
    }

    void setSelectionRange(LocationRange lr) {
        selectionRange = lr;
    }

    // insert
    void insert(char c) {
        insert(String.valueOf(c));
    }

    void insert(String str) {
        Location curr = getCursorLocation();
        Vector<String> splitLine = new Vector<String>(Arrays.asList(str.split("\n")));
        String line = lines.get(curr.y);

        if (splitLine.size() > 1) {
            String first = line.substring(0, curr.x);
            String end = splitLine.get(1);
            lines.add(curr.y + 1, "");
            lines.set(curr.y, first);
            lines.set(curr.y + 1, end);
            moveCursorDown();
        } else if (line.length() == curr.x && str == "") {
            lines.add(curr.y + 1, "");
            moveCursorDown();
        } else if (curr.x == 0 && str == "") {
            System.out.println(str);
            lines.add(curr.y + 1, line);
            lines.set(curr.y, "");
            moveCursorDown();
        } else {
            String first = "";
            if (curr.x != 0) {
                first = line.substring(0, curr.x);
            }
            String end = "";
            if (curr.x != line.length()) {
                end = line.substring(curr.x);
            }
            lines.set(curr.y, first + str + end);
            moveCursorRight();
        }
        this.txtObserver.updateText();
    }


    // clipboard

    public void setClipboardStack(ClipboardStack observer) {
        if (this.clipboardStack == null) {
            this.clipboardStack = observer;
        }
    }

    public void removeClipboardStack() {
        this.clipboardStack = null;
    }

    public ClipboardStack getClipboardStack() {
        return clipboardStack;
    }

    public String getClipboardString(LocationRange r) {
        System.out.println(r);
        if (r.start.y == r.end.y) {
            String currLine = lines.get(r.start.y);
            return currLine.substring(r.start.x, r.end.x);
        } else {
            String currLine = "";
            for (int i = r.start.y + 1; i < r.start.y; i++) {
                currLine += lines.get(i);
                currLine += "\n";
            }
            return lines.get(r.start.y).substring(r.start.x) + "\n"
                    + currLine
                    + lines.get(r.end.y).substring(0, r.end.x);
        }
    }
}
