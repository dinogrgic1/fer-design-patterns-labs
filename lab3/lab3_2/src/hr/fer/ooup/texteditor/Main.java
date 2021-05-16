package hr.fer.ooup.texteditor;

public class Main {

    public static void main(String[] args) {
        String show = "test123.\n" +
                "\n" +
                "test1234\n" +
                "\n" +
                "ttttt.\n" +
                "\n";
        TextEditor te = new TextEditor("Text editor", new TextEditorModel(show));
        EditorCanvas ec = new EditorCanvas();
        te.add(ec);
    }
}
