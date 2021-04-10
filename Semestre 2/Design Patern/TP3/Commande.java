/**
 * Interface des commandes pour le jeu de la vie
 * @author Julien PROUDY
 */
public abstract class Commande {
    
    protected Cellule cellule;

    public abstract void executer();

}
