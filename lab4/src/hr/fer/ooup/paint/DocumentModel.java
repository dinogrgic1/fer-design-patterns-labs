package hr.fer.ooup.paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentModel {

    public final static double SELECTION_PROXIMITY = 10;

    private List<IGraphicalObject> objects = new ArrayList<>();
    private List<IGraphicalObject> roObjects = Collections.unmodifiableList(objects);
    private List listeners = new ArrayList<>();
    private List selectedObjects = new ArrayList<>();
    private List roSelectedObjects = Collections.unmodifiableList(selectedObjects);

    private final IGraphicalObjectListener goListener = new IGraphicalObjectListener() {
        @Override
        public void graphicalObjectChanged(IGraphicalObject go) {

        }

        @Override
        public void graphicalObjectSelectionChanged(IGraphicalObject go) {

        }
    };

    public DocumentModel(ArrayList<IGraphicalObject> objects) {
        this.objects = objects;
        this.roObjects = Collections.unmodifiableList(objects);
    }

    // Brisanje svih objekata iz modela (pazite da se sve potrebno odregistrira)
    // i potom obavijeste svi promatrači modela
    public void clear() {

        for(IGraphicalObject o : this.objects) {
            o.removeGraphicalObjectListener(goListener);
        }
        this.objects = new ArrayList<>();
        this.roObjects = Collections.unmodifiableList(objects);

        this.listeners = new ArrayList<>();
        // obavijesti promatrace
        this.selectedObjects = new ArrayList<>();
        this.roSelectedObjects = Collections.unmodifiableList(selectedObjects);
    }

    // Dodavanje objekta u dokument (pazite je li već selektiran; registrirajte model kao promatrača)
    public void addGraphicalObject(IGraphicalObject obj) {
    }

    // Uklanjanje objekta iz dokumenta (pazite je li već selektiran; odregistrirajte model kao promatrača)
    public void removeGraphicalObject(IGraphicalObject obj) {
    }

    // Vrati nepromjenjivu listu postojećih objekata (izmjene smiju ići samo kroz metode modela)
    public List list() {
        return roObjects;
    }

    // Prijava...
    public void addDocumentModelListener(IDocumentModelListener l) {
    }

    // Odjava...
    public void removeDocumentModelListener(IDocumentModelListener l) {
    }

    // Obavještavanje...
    public void notifyListeners() {
    }

    // Vrati nepromjenjivu listu selektiranih objekata
    public List getSelectedObjects() {
        return null;
    }

    // Pomakni predani objekt u listi objekata na jedno mjesto kasnije...
    // Time će se on iscrtati kasnije (pa će time možda veći dio biti vidljiv)
    public void increaseZ(IGraphicalObject go) {
    }

    // Pomakni predani objekt u listi objekata na jedno mjesto ranije...
    public void decreaseZ(IGraphicalObject go) {
    }

    // Pronađi postoji li u modelu neki objekt koji klik na točku koja je
    // predana kao argument selektira i vrati ga ili vrati null. Točka selektira
    // objekt kojemu je najbliža uz uvjet da ta udaljenost nije veća od
    // SELECTION_PROXIMITY. Status selektiranosti objekta ova metoda NE dira.
    public IGraphicalObject findSelectedGraphicalObject(Point mousePoint) {
        return null;
    }

    // Pronađi da li u predanom objektu predana točka miša selektira neki hot-point.
    // Točka miša selektira onaj hot-point objekta kojemu je najbliža uz uvjet da ta
    // udaljenost nije veća od SELECTION_PROXIMITY. Vraća se indeks hot-pointa
    // kojeg bi predana točka selektirala ili -1 ako takve nema. Status selekcije
    // se pri tome NE dira.
    public int findSelectedHotPoint(IGraphicalObject object, Point mousePoint) {
        return 0;
    }
}
