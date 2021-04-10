/**
 * Cette classe déclanche la méthode de la commande associé à la résurection d'une cellule 
 * @author Julien PROUDY
 */
public class CommandeVit extends Commande {

    /**
     * Constructeur d'une commande de retour à la vie d'une cellule
     * @param c La cellule qui sera concernée par cette commande
     */
    public CommandeVit(Cellule c){
        cellule = c;
    }

    /**
     * Exécute le retour à la vie d'une cellule
     */
    @Override
    public void executer() {
        cellule.vit();
    }
    
}
