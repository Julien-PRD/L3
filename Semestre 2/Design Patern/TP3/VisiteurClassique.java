/**
 * Cette classe est le visiteur qui permet aux cellules de vivres ou mourrir en fonction de leur nombre de voisins
 * @author Julien PROUDY
 */
public class VisiteurClassique extends Visiteur {

    /**
     * Constructeur d'un visiteur classique
     * @param jeu
     */
    public VisiteurClassique(JeuDeLaVie jeu) {
        super(jeu);
    }
    
    /** 
     * Méthode qui va instancier et ajouter une nouvelle commande (CommandeMeurt) selon les voisines de la cellule
     * @param cellule La cellule concerné
     */
    @Override
    public void visiteCelluleVivante(Cellule cellule) {
        if( cellule.nombreVoisinesVivantes(jeu) <2 || cellule.nombreVoisinesVivantes(jeu) > 3 ){
            jeu.ajouteCommande(new CommandeMeurt(cellule));
        }
    }
    
    /** 
     * Méthode qui va instancier et ajouter une nouvelle commande (CommandeVit) selon les voisines de la cellule
     * @param cellule La cellule concerné
     */
    @Override
    public void visiteCelluleMorte(Cellule cellule) {
        if(cellule.nombreVoisinesVivantes(jeu)==3){
            jeu.ajouteCommande(new CommandeVit(cellule));
        }
    }
    
}
