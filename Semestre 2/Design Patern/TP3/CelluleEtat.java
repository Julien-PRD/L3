/**
 * Interface qui renseigne les caratéristiques sur l'état d'une cellule
 * @author Julien PROUDY
 */
public interface CelluleEtat {
    
    CelluleEtat vit();
    CelluleEtat meurt();
    boolean estVivante();
    void accepte(Visiteur visiteur, Cellule cellule);

}
