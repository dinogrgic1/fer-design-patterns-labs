package hr.fer.ooup.texteditor;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextEditor extends JFrame implements KeyListener {

    public TextEditorModel tem;

    private Boolean shiftPressed = false;
    private Location shiftStart = null;
    private Boolean shiftReleaseOnLast = false;
    private int lastPressed = 0;

    TextEditor(String title, TextEditorModel tem) {
        super(title);
        super.setSize(900, 900);
        super.addKeyListener(this);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

        this.tem = tem;
        CursorObserver observer = new CursorObserver(this);
        this.tem.setObserver(observer);

        TextObserver txtObserver = new TextObserver(this);
        this.tem.setTxtObserver(txtObserver);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyPressed = keyEvent.getKeyCode();
        switch (keyPressed) {
            case KeyEvent.VK_SHIFT:
                shiftPressed = true;
                shiftStart = new Location(tem.getCursorLocation());
                break;
            case KeyEvent.VK_UP:
                lastPressed = keyPressed;
                tem.moveCursorUp();
                break;
            case KeyEvent.VK_DOWN:
                lastPressed = keyPressed;
                tem.moveCursorDown();
                break;
            case KeyEvent.VK_LEFT:
                lastPressed = keyPressed;
                tem.moveCursorLeft();
                break;
            case KeyEvent.VK_RIGHT:
                lastPressed = keyPressed;
                tem.moveCursorRight();
                break;
            case KeyEvent.VK_BACK_SPACE:
                if (shiftReleaseOnLast) {
                    tem.deleteRange(tem.getLatestSelectionRange());
                    shiftReleaseOnLast = false;
                } else {
                    tem.deleteBefore();
                }
                break;
            case KeyEvent.VK_DELETE:
                if (shiftReleaseOnLast) {
                    tem.deleteRange(tem.getLatestSelectionRange());
                } else {
                    tem.deleteAfter();
                }
                break;
            case KeyEvent.VK_ENTER:
                Location l = tem.getCursorLocation();
                String line = tem.getLines().get(l.y);

                String format = "";
                if (l.x != 0 && l.x != line.length()) {
                    format = String.format("\n%s", line.substring(l.x));
                }
                tem.insert(format);
                break;
            default:
                if (shiftReleaseOnLast) {
                    tem.deleteRange(tem.getLatestSelectionRange());
                }
                if (keyPressed >= KeyEvent.VK_SPACE && keyPressed < KeyEvent.VK_DELETE) {
                    lastPressed = keyPressed;
                    shiftPressed = false;
                    tem.setSelectionRange(null);
                    tem.insert(keyEvent.getKeyChar());
                }
                break;
        }

        if (shiftPressed) {
            tem.setSelectionRange(shiftStart, tem.getCursorLocation());
        } else {
            shiftReleaseOnLast = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int keyPressed = keyEvent.getKeyCode();

        if (lastPressed == KeyEvent.VK_LEFT || lastPressed == KeyEvent.VK_RIGHT ||
                lastPressed == KeyEvent.VK_UP || lastPressed == KeyEvent.VK_DOWN) {
            if (keyPressed == KeyEvent.VK_SHIFT) {
                shiftPressed = false;
                shiftReleaseOnLast = true;
                shiftStart = null;
                tem.setLatestSelectionRange();
                tem.setSelectionRange(null);
            }
        }


    }
}
