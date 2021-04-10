/**
 * Cette classe déclanche la méthode de la commande associé à la mort d'une cellule 
 * @author Julien PROUDY
 */
public class CommandeMeurt extends Commande{

    /**
     * Constructeur d'une commande de mort d'une cellule
     * @param c La cellule qui sera concernée par cette commande
     */
    public CommandeMeurt(Cellule c){
        cellule = c;
    }

    /**
     * Exécute la mort d'une cellule
     */
    @Override
    public void executer() {
       cellule.meurt();
    }
    
}
