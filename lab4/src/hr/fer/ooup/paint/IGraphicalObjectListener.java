package hr.fer.ooup.paint;

public interface IGraphicalObjectListener {
    // Poziva se kad se nad objektom promjeni bio što...
    void graphicalObjectChanged(IGraphicalObject go);
    // Poziva se isključivo ako je nad objektom promjenjen status selektiranosti
    // (baš objekta, ne njegovih hot-point-a).
    void graphicalObjectSelectionChanged(IGraphicalObject go);
}
