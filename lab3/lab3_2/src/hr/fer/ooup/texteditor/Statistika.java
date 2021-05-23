package hr.fer.ooup.texteditor;

public class Statistika implements IPlugin{
    @Override
    public String getName() {
        return "Statistika";
    }

    @Override
    public String getDescription() {
        return "Statistika slova";
    }

    @Override
    public void execute(TextEditorModel model, UndoManager undoManager, ClipboardStack clipboardStack) {
        return;
    }
}
