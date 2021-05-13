package hr.fer.ooup.texteditor;

public class Main {

    public static void main(String[] args) {
        TextEditor te = new TextEditor("Text editor");
        EditorCanvas ec = new EditorCanvas();
        te.add(ec);
    }
}
