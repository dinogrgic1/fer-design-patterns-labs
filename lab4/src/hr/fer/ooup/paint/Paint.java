package hr.fer.ooup.paint;

import java.util.ArrayList;

public class Paint {
    public static void main(String[] args) {
        ArrayList<IGraphicalObject> objects = new ArrayList<>();

        objects.add(new LineSegment(new Point(450, 400), new Point(450, 500)));
        objects.add(new LineSegment(new Point(400, 500), new Point(450, 500)));

        objects.add(new Oval(new Point(450, 400), new Point(400, 500)));

        GUI gui = new GUI(objects);
        gui.setVisible(true);
    }
}
