package hr.fer.ooup.paint.states;

import hr.fer.ooup.paint.render.IGraphicalObject;
import hr.fer.ooup.paint.render.IRenderer;
import hr.fer.ooup.paint.geometry.Point;

public interface IState {
    // poziva se kad progam registrira da je pritisnuta lijeva tipka miša
    void mouseDown(Point mousePoint, boolean shiftDown, boolean ctrlDown);
    // poziva se kad progam registrira da je otpuštena lijeva tipka miša
    void mouseUp(Point mousePoint, boolean shiftDown, boolean ctrlDown);
    // poziva se kad progam registrira da korisnik pomiče miš dok je tipka pritisnuta
    void mouseDragged(Point mousePoint);
    // poziva se kad progam registrira da je korisnik pritisnuo tipku na tipkovnici
    void keyPressed(int keyCode);

    // Poziva se nakon što je platno nacrtalo grafički objekt predan kao argument
    void afterDraw(IRenderer r, IGraphicalObject go);
    // Poziva se nakon što je platno nacrtalo čitav crtež
    void afterDraw(IRenderer r);

    // Poziva se kada program napušta ovo stanje kako bi prešlo u neko drugo
    void onLeaving();
}