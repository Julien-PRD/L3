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

    @Override
    public CelluleEtat vit() {
        return new CelluleEtatVivant();
    }

    @Override
    public CelluleEtat meurt() {
        return this;
    }

    @Override
    public boolean estVivante() {
        return false;
    }
    
}
