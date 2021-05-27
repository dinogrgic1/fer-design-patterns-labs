package hr.fer.ooup.paint.render;

import hr.fer.ooup.paint.geometry.GeometryUtil;
import hr.fer.ooup.paint.geometry.Point;
import hr.fer.ooup.paint.geometry.Rectangle;

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
        this.hotPointSelected = new boolean[hotPoints.length];
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
        for(Point p : hotPoints) {
            p.translate(delta);
        }
    }

    @Override
    abstract public Rectangle getBoundingBox();

    @Override
    abstract public double selectionDistance(Point mousePoint);
    @Override
    public void addGraphicalObjectListener(IGraphicalObjectListener l) {
        listeners.add(l);
    }

    @Override
    public void removeGraphicalObjectListener(IGraphicalObjectListener l) {
        listeners.remove(l);
    }

    @Override
    abstract public String getShapeName();

    @Override
    abstract public IGraphicalObject duplicate();

    @Override
    public void load(Stack<IGraphicalObject> stack, String data) {

    }
}
