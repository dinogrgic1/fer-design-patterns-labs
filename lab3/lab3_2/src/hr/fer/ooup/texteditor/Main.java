package hr.fer.ooup.texteditor;

public class Main {

    public static void main(String[] args) {
        String show = "test123.\n" +
                "asfdjasdlkfjasldkfjas\n" +
                "test1234\n" +
                "\n" +
                "ttttt.\n" +
                "asdflka;fkawe;lfkw;l\n";
        TextEditor te = new TextEditor("Text editor", new TextEditorModel(show));
        EditorCanvas ec = new EditorCanvas();
        te.add(ec);
    }
}
