/**
 * Cette classe est le visiteur qui permet aux cellules de vivres ou mourrir en fonction de leur nombre de voisins, c'est une règle variante de celle de base
 * @author Julien PROUDY
 */
public class VisiteurDayAndNight extends Visiteur{

    /**
     * Constructeur d'un visiteur avec comme règle DayAndNight
     * @param jeu
     */
    public VisiteurDayAndNight(JeuDeLaVie jeu) {
        super(jeu);
    }

    /** 
     * Méthode qui va instancier et ajouter une nouvelle commande (CommandeMeurt) selon les voisines de la cellule
     *  Une cellule vivante survit à l'étape suivante si elle est entourée de 3, 4, 6, 7 ou 8 cellules vivantes
     * @param cellule La cellule concerné
     */
    @Override
    public void visiteCelluleVivante(Cellule cellule) {
        if( cellule.nombreVoisinesVivantes(jeu) <=2 || cellule.nombreVoisinesVivantes(jeu) == 5 ){
            jeu.ajouteCommande(new CommandeMeurt(cellule));
        }
    }

    /** 
     * Méthode qui va instancier et ajouter une nouvelle commande (CommandeVit) selon les voisines de la cellule
     *  Une cellule morte y naît à l'étape suivante si elle est entourée de 3, 6, 7 ou 8 voisines mortes
     * @param cellule La cellule concerné
     */
    @Override
    public void visiteCelluleMorte(Cellule cellule) {
        int nbCelluleMorte = 8 - cellule.nombreVoisinesVivantes(jeu);
        if( (nbCelluleMorte==3) || (nbCelluleMorte >= 6) ){
            jeu.ajouteCommande(new CommandeMeurt(cellule));
        }else{
            jeu.ajouteCommande(new CommandeVit(cellule));
        }
    }
    
}
