package hr.fer.ooup.texteditor;

import java.util.Stack;

public class ClipboardStack implements IClipboardStack {
    private Stack<String> stack;
    private TextEditor te;

    public ClipboardStack(TextEditor tem) {
        this.te = tem;
        this.stack = new Stack<String>();
    }

    public String pop() {
        String str = null;
        if (!stack.empty()) {
            str = this.stack.pop();
        }
        return str;
    }

    public void push(String str) {
        this.stack.push(str);
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public String peek() {
        return this.stack.peek();
    }

    public void delete() {
        this.stack.empty();
    }

    @Override
    public void updateClipboard() {
        this.te.repaint();
    }

}
