package hr.fer.ooup.paint.states;

import hr.fer.ooup.paint.geometry.Point;
import hr.fer.ooup.paint.render.IGraphicalObject;
import hr.fer.ooup.paint.render.IRenderer;

public class SelectShapeState implements IState{
    @Override
    public void mouseDown(Point mousePoint, boolean shiftDown, boolean ctrlDown) {
        System.out.println("mouse");
    }

    @Override
    public void mouseUp(Point mousePoint, boolean shiftDown, boolean ctrlDown) {

    }

    @Override
    public void mouseDragged(Point mousePoint) {

    }

    @Override
    public void keyPressed(int keyCode) {

    }

    @Override
    public void afterDraw(IRenderer r, IGraphicalObject go) {

    }

    @Override
    public void afterDraw(IRenderer r) {

    }

    @Override
    public void onLeaving() {

    }
}
