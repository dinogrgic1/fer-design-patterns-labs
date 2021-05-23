package hr.fer.ooup.texteditor;

public interface IPlugin {
    String getName();
    String getDescription();
    void execute(TextEditorModel model, UndoManager undoManager, ClipboardStack clipboardStack);
}
