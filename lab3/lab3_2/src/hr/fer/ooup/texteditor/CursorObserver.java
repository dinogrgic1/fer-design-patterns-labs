package hr.fer.ooup.texteditor;

public class CursorObserver implements ICursorObserver {

    private TextEditor te;

    public CursorObserver(TextEditor tem) {
        this.te = tem;
    }

    @Override
    public void updateCursorLocation() {
        this.te.repaint();
    }

}
