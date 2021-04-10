/**
 * La classe abtraite des visiteurs
 * @author Julien PROUDY
 */
public abstract class Visiteur {
    
    protected JeuDeLaVie jeu;

    /**
     * Constructeur d'un visiteur
     * @param jeu le jeu de la vie
     */
    public Visiteur(JeuDeLaVie jeu){
        this.jeu = jeu;
    }

    public abstract void visiteCelluleVivante(Cellule cellule);

    public abstract void visiteCelluleMorte(Cellule cellule);

}
