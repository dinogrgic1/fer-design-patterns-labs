package hr.fer.ooup.paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentModel {

    public final static double SELECTION_PROXIMITY = 10;

    private List<IGraphicalObject> objects;
    private List<IGraphicalObject> roObjects;
    private List<IDocumentModelListener> listeners = new ArrayList<>();
    private List<IGraphicalObject> selectedObjects = new ArrayList<>();
    private List<IGraphicalObject> roSelectedObjects = Collections.unmodifiableList(selectedObjects);

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

    /**
     * Brisanje svih objekata iz modela (pazite da se sve potrebno odregistrira)
     * i potom obavijeste svi promatrači modela
     */
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

    /**
     * Dodavanje objekta u dokument (pazite je li već selektiran; registrirajte model kao promatrača)
     * @param obj Graphical object to be added to model.
     */
    public void addGraphicalObject(IGraphicalObject obj) {

        // Sanity.
        if(obj == null) {
            return;
        }

        obj.addGraphicalObjectListener(goListener);
        this.objects.add(obj);
    }

    /**
     * Uklanjanje objekta iz dokumenta (pazite je li već selektiran; odregistrirajte model kao promatrača)
     * @param obj Graphical object to be removed from model.
     */
    public void removeGraphicalObject(IGraphicalObject obj) {

        // Sanity.
        if(obj == null) {
            return;
        }

        obj.removeGraphicalObjectListener(goListener);
        this.objects.remove(obj);
    }

    /**
     * Vrati nepromjenjivu listu postojećih objekata (izmjene smiju ići samo kroz metode modela)
     * @return Read only graphical object list.
     */
    public List<IGraphicalObject> list() {
        return roObjects;
    }

    /**
     * Prijava...
     * @param l Document model listener...
     */
    public void addDocumentModelListener(IDocumentModelListener l) {
        this.listeners.add(l);
    }

    /**
     * Odjava...
     * @param l Document model listener...
     */
    public void removeDocumentModelListener(IDocumentModelListener l) {
        this.listeners.remove(l);
    }

    /**
     * Obavještavanje...
     */
    public void notifyListeners() {
        for(IDocumentModelListener dml : this.listeners) {
            dml.notify();
        }
    }

    /**
     * Vrati nepromjenjivu listu selektiranih objekata
     * @return Read only graphical object list.
     */
    public List<IGraphicalObject> getSelectedObjects() {
        return this.roSelectedObjects;
    }

    /**
     * Pomakni predani objekt u listi objekata na jedno mjesto kasnije...
     * Time će se on iscrtati kasnije (pa će time možda veći dio biti vidljiv)
     * @param go GraphicalObject za switch.
     */
    public void increaseZ(IGraphicalObject go) {
        int idx = this.objects.indexOf(go);
        if(idx == -1 || idx == this.objects.size() - 1) {
            return;
        }
        Collections.swap(this.objects, idx, idx+1);
    }

    /**
     * Pomakni predani objekt u listi objekata na jedno mjesto ranije...
     * @param go GraphicalObject za switch.
     */
    public void decreaseZ(IGraphicalObject go) {
        int idx = this.objects.indexOf(go);
        if(idx < 1) {
            return;
        }
        Collections.swap(this.objects, idx, idx-1);
    }

    /**
     * Pronađi postoji li u modelu neki objekt koji klik na točku koja je
     * predana kao argument selektira i vrati ga ili vrati null. Točka selektira
     * objekt kojemu je najbliža uz uvjet da ta udaljenost nije veća od
     * SELECTION_PROXIMITY. Status selektiranosti objekta ova metoda NE dira.
     * @param mousePoint
     * @return
     */
    public IGraphicalObject findSelectedGraphicalObject(Point mousePoint) {
        return null;
    }

    /**
     * Pronađi da li u predanom objektu predana točka miša selektira neki hot-point.
     * Točka miša selektira onaj hot-point objekta kojemu je najbliža uz uvjet da ta
     * udaljenost nije veća od SELECTION_PROXIMITY. Vraća se indeks hot-pointa
     * kojeg bi predana točka selektirala ili -1 ako takve nema. Status selekcije
     * se pri tome NE dira.
     * @param object Graphical object
     * @param mousePoint Mouse point location
     * @return
     */
    public int findSelectedHotPoint(IGraphicalObject object, Point mousePoint) {
        return 0;
    }
}
