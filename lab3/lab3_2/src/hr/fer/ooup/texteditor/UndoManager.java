package hr.fer.ooup.texteditor;

import java.util.Stack;

public class UndoManager implements IEditAction {

    private Stack<IEditAction> undoStack;
    private Stack<IEditAction> redoStack;

    public UndoManager() {
        undoStack = new Stack<IEditAction>();
        redoStack = new Stack<IEditAction>();
    }

    @Override
    public void execute_do() {

    }

    @Override
    public void execute_undo() {

    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            IEditAction editAction = undoStack.pop();
            redoStack.push(editAction);
        }
    }

    public void push(IEditAction c) {
        redoStack = new Stack<IEditAction>();
        undoStack.push(c);
    }
}
