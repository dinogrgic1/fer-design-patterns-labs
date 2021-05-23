package hr.fer.ooup.texteditor;

public class VelikoSlovo implements IPlugin {
    @Override
    public String getName() {
        return "Veliko slovo";
    }

    @Override
    public String getDescription() {
        return "Pretvara sve pocetke rijeci u velika slova";
    }

    @Override
    public void execute(TextEditorModel model, UndoManager undoManager, ClipboardStack clipboardStack) {
        for(String line : model.getLines())
        {
            StringBuffer newString = new StringBuffer();
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                newString.append(Character.toUpperCase(words[i].charAt(0)))
                        .append(words[i].substring(1)).append(" ");
            }
            line = newString.toString();
        }
    }
}
