package hr.fer.ooup.texteditor;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class EditorCanvas  extends JComponent {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        Line2D lin = new Line2D.Float(7, 0, 7, 14);
        g2D.draw(lin);

        String text1 = "abcd";
        String text2 = "abcdefgh";
        g2D.setFont(new Font("Arial", Font.PLAIN, 14));
        g2D.drawString(text1, 0, 14);
        g2D.drawString(text2, 0, 28);
        g2D.drawString(text1, 0, 42);
        System.out.println(g2D.getFontMetrics().getHeight());
        System.out.println(g2D.getFontMetrics().getMaxAscent());
    }
}
