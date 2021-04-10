/**
 * Cette classe qui implémente l'interface CelluleEtat permet de faire les changements d'état d'une cellule vers une cellule vivante
 * @author Julien PROUDY
 */
public class CelluleEtatVivant implements CelluleEtat {

    private static CelluleEtatVivant cell = null;

    /**
     * Retourne une instance de CelluleEtatVivant
     * @return Instance de CelluleEtatVivant
     */
    public static synchronized CelluleEtatVivant getInstance(){
		if(cell == null){
			cell = new CelluleEtatVivant(); 
		}
		return cell; 
	}

    
    /** 
     * La cellule est déja vivante donc on la retourne à elle même
     * @return CelluleEtat 
     */
    @Override
    public CelluleEtat vit() {
        return this;
    }

    
    /**
     * la cellule étant vivante, on la modifie en créant une nouvelle cellule qui sera morte 
     * @return CelluleEtat
     */
    @Override
    public CelluleEtat meurt() {
        return new CelluleEtatMort();
    }

    
    /** 
     * L'état cellule étant vivante dans cette classe, alors cette méthode renvoie true.
     * @return true
     */
    @Override
    public boolean estVivante() {
        return true;
    }

    
    /**
     * La cellule accepte le visiteur avec la méthode de ce dernier qui correspond à l'état de la cellule, ici ça sera visiteCelluleVivante()
     * @param visiteur Le visiteur
     * @param cellule La cellule a traiter
     */
    @Override
    public void accepte(Visiteur visiteur, Cellule cellule) {
        visiteur.visiteCelluleVivante(cellule);
    }
    
    

}
