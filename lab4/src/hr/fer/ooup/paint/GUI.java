package hr.fer.ooup.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    DocumentModel dm;

    public GUI(ArrayList<IGraphicalObject> objects) {
        super("Paint");
        this.dm = new DocumentModel(objects);
        this.setSize(900, 900);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        JPanel jp = new JPanel(new BorderLayout());
        jp.add(jbt, BorderLayout.PAGE_START);
        jp.add(new Canvas(), BorderLayout.CENTER);
        this.add(jp);
    }
}
