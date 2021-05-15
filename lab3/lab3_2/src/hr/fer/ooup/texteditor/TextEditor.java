package hr.fer.ooup.texteditor;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextEditor extends JFrame implements KeyListener {

    TextEditorModel tem;
    CursorObserver observer;

    TextEditor(String title, TextEditorModel tem) {
        super(title);
        super.setSize(900, 900);
        super.addKeyListener(this);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

        this.tem = tem;
        this.observer = new CursorObserver(this.tem);
        this.tem.setObserver(observer);
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
            case KeyEvent.VK_UP:
                tem.moveCursorUp();
                break;
            case KeyEvent.VK_DOWN:
                tem.moveCursorDown();
                break;
            case KeyEvent.VK_LEFT:
                tem.moveCursorLeft();
                break;
            case KeyEvent.VK_RIGHT:
                tem.moveCursorRight();
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
