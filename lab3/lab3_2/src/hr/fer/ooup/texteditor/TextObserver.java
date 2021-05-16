package hr.fer.ooup.texteditor;

public class TextObserver implements ITextObserver {
    private TextEditor te;

    public TextObserver(TextEditor te) {
        this.te = te;
    }

    @Override
    public void updateText() {
        this.te.repaint();
    }
}
