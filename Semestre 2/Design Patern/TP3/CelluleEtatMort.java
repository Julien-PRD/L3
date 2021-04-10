/**
 * Cette classe qui implémente l'interface CelluleEtat permet de faire les changements d'état d'une cellule vers une cellule morte
 * @author Julien PROUDY
 */
public class CelluleEtatMort implements CelluleEtat {

    private static CelluleEtatMort cell = null;

    /**
     * Retourne une instance de CelluleEtatMort
     * @return Instance de CelluleEtatMort
     */
    public static synchronized CelluleEtatMort getInstance(){
		if(cell == null){
			cell = new CelluleEtatMort(); 
		}
		return cell; 
	}

    
    /**
     * la cellule étant morte, on la modifie en créant une nouvelle cellule qui sera vivante 
     * @return CelluleEtat
     */
    @Override
    public CelluleEtat vit() {
        return new CelluleEtatVivant();
    }

    
    /** 
     * La cellule est déja morte donc on la retourne à elle même
     * @return CelluleEtat 
     */
    @Override
    public CelluleEtat meurt() {
        return this;
    }

    
    /** 
     * L'état cellule étant morte dans cette classe, alors cette méthode renvoie false.
     * @return false 
     */
    @Override
    public boolean estVivante() {
        return false;
    }

     /**
      * La cellule accepte le visiteur avec la méthode de ce dernier qui correspond à l'état de la cellule, ici ça sera visiteCelluleMorte()
     * @param visiteur Le visiteur
     * @param cellule La cellule a traiter
     */
    @Override
    public void accepte(Visiteur visiteur, Cellule cellule) {
        visiteur.visiteCelluleMorte(cellule);
    }
    
}
