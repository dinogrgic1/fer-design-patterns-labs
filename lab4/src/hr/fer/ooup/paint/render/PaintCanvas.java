package hr.fer.ooup.paint.render;

import hr.fer.ooup.paint.geometry.Point;
import hr.fer.ooup.paint.states.IState;
import hr.fer.ooup.paint.states.IdleState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintCanvas extends JComponent implements KeyListener, MouseListener{

    private GUI gui;

    public PaintCanvas(GUI gui) {
        this.gui = gui;
        this.setSize(900, 900);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        IRenderer r = new G2DRendererImpl(g2d);
        for (IGraphicalObject o : this.gui.getDocumentModel().list()) {
            o.render(r);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                this.gui.setCurrentState(new IdleState());
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) { }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point delta = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.gui.getCurrentState().mouseDown(delta, false, false);
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) { }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }

    @Override
    public void mouseExited(MouseEvent mouseEvent) { }
}
