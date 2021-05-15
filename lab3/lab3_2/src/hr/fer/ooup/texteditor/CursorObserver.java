package hr.fer.ooup.texteditor;

public class CursorObserver implements ICursorObserver {

    private TextEditorModel tem;

    public CursorObserver(TextEditorModel tem) {
        this.tem = tem;
    }

    @Override
    public void updateCursorLocation(Location loc) {
        System.out.println(loc);
        this.tem.setCursorLocation(loc);
    }

}
