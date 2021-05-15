package hr.fer.ooup.texteditor;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.ListIterator;

public class EditorCanvas extends JComponent {
    private final Integer FONT_SIZE = 16;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));

        try {
            TextEditor te = (TextEditor) SwingUtilities.getWindowAncestor(this);

            int i = FONT_SIZE;
            for (ListIterator<String> it = te.tem.allLines(); it.hasNext(); ) {
                String line = it.next();
                g2D.drawString(line, 0, i);
                i += FONT_SIZE;
            }

            Location l = te.tem.getCursorLocation();
            LocationRange lr = getCursorLocation(g2D, l, te.tem.getLines());
            Line2D lin = new Line2D.Float(lr.start.x, lr.start.y, lr.end.x, lr.end.y);
            g2D.setColor(Color.red);
            g2D.draw(lin);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private LocationRange getCursorLocation(Graphics2D g2D, Location loc, List<String> textArr)
    {
        String s = textArr.get(loc.y);
        int stringWidth = 0;
        if(loc.x > s.length())
            stringWidth = g2D.getFontMetrics().stringWidth(textArr.get(loc.y).substring(0, s.length()));
        else
            stringWidth = g2D.getFontMetrics().stringWidth(textArr.get(loc.y).substring(0, loc.x));

        Location l1 = new Location(stringWidth, loc.y * FONT_SIZE);
        Location l2 = new Location(stringWidth, (loc.y + 1) * FONT_SIZE);
        return new LocationRange(l1, l2);
    }

}
