package hr.fer.ooup.paint;

import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JComponent {

    DocumentModel dm;

    public PaintCanvas(DocumentModel dm) {
        this.dm = dm;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        IRenderer r = new G2DRendererImpl(g2d);
        for (IGraphicalObject o : this.dm.list()) {
            o.render(r);
        }
    }
}
