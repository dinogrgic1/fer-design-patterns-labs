package hr.fer.ooup.paint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

abstract public class AbstractGraphicalObject implements IGraphicalObject{

    private Point[] hotPoints;
    private boolean[] hotPointSelected;
    private boolean selected;
    protected List<IGraphicalObjectListener> listeners = new ArrayList<>();

    protected AbstractGraphicalObject(Point[] points) {
        this.hotPoints = points;
        this.selected = false;
        Arrays.fill(this.hotPointSelected, Boolean.FALSE);
    }

    @Override
    public boolean isSelected() { return this.selected; }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int getNumberOfHotPoints() { return hotPoints.length; }

    @Override
    public Point getHotPoint(int index) { return hotPoints[index]; }

    @Override
    public void setHotPoint(int index, Point point) { hotPoints[index] = point; }

    @Override
    public boolean isHotPointSelected(int index) { return hotPointSelected[index]; }

    @Override
    public void setHotPointSelected(int index, boolean selected) {
        hotPointSelected[index] = selected;
    }

    @Override
    public double getHotPointDistance(int index, Point mousePoint) {
        Point start = hotPoints[index];
        return GeometryUtil.distanceFromPoint(start, mousePoint);
    }

    @Override
    public void translate(Point delta) {
        delta.translate(delta);
    }

    @Override
    public Rectangle getBoundingBox() {
        return null;
    }

    @Override
    public double selectionDistance(Point mousePoint) {
        return 0;
    }

    @Override
    public void addGraphicalObjectListener(IGraphicalObjectListener l) {
        listeners.add(l);
    }

    @Override
    public void removeGraphicalObjectListener(IGraphicalObjectListener l) {
        listeners.remove(l);
    }

    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public IGraphicalObject duplicate() {
        return null;
    }

    @Override
    public void load(Stack<IGraphicalObject> stack, String data) {

    }
}
