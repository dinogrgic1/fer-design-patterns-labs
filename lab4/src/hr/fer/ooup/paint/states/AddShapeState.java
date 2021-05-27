package hr.fer.ooup.paint.states;

import hr.fer.ooup.paint.geometry.Point;
import hr.fer.ooup.paint.render.DocumentModel;
import hr.fer.ooup.paint.render.IGraphicalObject;
import hr.fer.ooup.paint.render.IRenderer;

public class AddShapeState implements IState {

    private IGraphicalObject prototype;
    private DocumentModel model;

    public AddShapeState(DocumentModel model, IGraphicalObject prototype) {
        System.out.println("Entered AddShapeState");
        this.model = model;
        this.prototype = prototype;
    }

    @Override
    public void mouseDown(Point mousePoint, boolean shiftDown, boolean ctrlDown) {
        this.prototype = this.prototype.duplicate();
        this.prototype.translate(mousePoint);
        this.model.addGraphicalObject(this.prototype);
    }

    @Override
    public void mouseUp(Point mousePoint, boolean shiftDown, boolean ctrlDown) { }

    @Override
    public void mouseDragged(Point mousePoint) { }

    @Override
    public void keyPressed(int keyCode) { }

    @Override
    public void afterDraw(IRenderer r, IGraphicalObject go) { }

    @Override
    public void afterDraw(IRenderer r) { }

    @Override
    public void onLeaving() { }
}