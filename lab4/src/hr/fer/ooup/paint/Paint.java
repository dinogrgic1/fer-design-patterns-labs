package hr.fer.ooup.paint;

import javax.swing.*;
import java.awt.*;

public class Paint {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Paint");
        jf.setSize(900, 900);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JToolBar jbt = new JToolBar();
        jbt.setFloatable(false);
        jbt.setRollover(true);
        jbt.addSeparator();

        JButton loadBtn = new JButton("Učitaj");
        jbt.add(loadBtn);
        JButton saveBtn = new JButton("Pohrani");
        jbt.add(saveBtn);
        JButton exportBtn = new JButton("SVG export");
        jbt.add(exportBtn);
        JButton lineBtn = new JButton("Linija");
        jbt.add(lineBtn);
        JButton ovalBtn = new JButton("Oval");
        jbt.add(ovalBtn);
        JButton selectBtn = new JButton("Selektiraj");
        jbt.add(selectBtn);
        JButton deleteBtn = new JButton("Brisalo");
        jbt.add(deleteBtn);

        BorderLayout bl = new BorderLayout();
        JPanel jp = new JPanel(new BorderLayout());
        jp.add(jbt, BorderLayout.PAGE_START);
        jp.add(new Canvas(), BorderLayout.CENTER);

        jf.add(jp);
        jf.setVisible(true);
    }
}
