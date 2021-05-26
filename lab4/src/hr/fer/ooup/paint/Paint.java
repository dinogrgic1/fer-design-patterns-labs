package hr.fer.ooup.paint;

import java.util.ArrayList;

public class Paint {
    public static void main(String[] args) {
        ArrayList<IGraphicalObject> objects = new ArrayList<>();

        objects.add(new LineSegment());
        objects.add(new Oval());

        GUI gui = new GUI(objects);
        gui.setVisible(true);
    }
}
