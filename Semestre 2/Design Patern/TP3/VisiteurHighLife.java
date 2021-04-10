/**
 * Cette classe est le visiteur qui permet aux cellules de vivres ou mourrir en fonction de leur nombre de voisins, c'est une règle variante de celle de base
 * @author Julien PROUDY
 */
public class VisiteurHighLife extends Visiteur{

    /**
     * Constructeur d'un visiteur avec comme règle HighLife
     * @param jeu
     */
    public VisiteurHighLife(JeuDeLaVie jeu) {
        super(jeu);
    }

    /** 
     * Méthode qui va instancier et ajouter une nouvelle commande (CommandeMeurt) selon les voisines de la cellule
     *  Une cellule vivante survit à l'étape suivante si elle est entourée de deux ou trois cellules vivantes
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
     *  Une cellule morte y naît à l'étape suivante si elle est entourée de 3 ou 6 voisines vivantes
     * @param cellule La cellule concerné
     */
    @Override
    public void visiteCelluleMorte(Cellule cellule) {
        if( (cellule.nombreVoisinesVivantes(jeu)==3) || (cellule.nombreVoisinesVivantes(jeu)==6) ){
            jeu.ajouteCommande(new CommandeVit(cellule));
        }
    }
    
}
