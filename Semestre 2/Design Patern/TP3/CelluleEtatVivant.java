public class CelluleEtatVivant implements CelluleEtat {

    private static CelluleEtatVivant cell = null;

    /**
     * Retourne une instance de CelluleEtatMort
     * @return Instance de CelluleEtatMort
     */
    public static synchronized CelluleEtatVivant getInstance(){
		if(cell == null){
			cell = new CelluleEtatVivant(); 
		}
		return cell; 
	}

    @Override
    public CelluleEtat vit() {
        return this;
    }

    @Override
    public CelluleEtat meurt() {
        return new CelluleEtatMort();
    }

    @Override
    public boolean estVivante() {
        return true;
    }

    @Override
    public void accepte(Visiteur visiteur, Cellule cellule) {
        visiteur.visiteCelluleVivante(cellule);
    }
    
    

}
