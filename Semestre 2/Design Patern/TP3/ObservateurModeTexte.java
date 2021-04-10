/**
 * Cette classe est un observateur qui s'occupera de l'affichage dans le terminal le déroulement du jeu
 * @author Julien PROUDY
 */
public class ObservateurModeTexte implements Observateur{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private JeuDeLaVie jeu;
    private int numGeneration;
    private int nbCelluleVivante;

    /**
     * Constructeur de l'observateur
     * @param jeu Le jeu de la vie qui benificiera de l'observateur
     */
    public ObservateurModeTexte(JeuDeLaVie jeu){
        this.jeu = jeu;
        numGeneration = 0;
        nbCelluleVivante = 0;

        jeu.attacheObservateur(this);      //On renseigne l'observateur au jeu

        actualise();
    }

    /**
     * A chaque tour, l'observateur va afficher dans la console Java le numéro de la génération courante et le nombre de cellules actuellement en vie (en couleur)
     */
    @Override
    public void actualise() { 
        numGeneration ++;
        for(int i=0 ; i<jeu.getXMax() ; i++){
            for(int j=0 ; j<jeu.getYMax() ; j++){
                if(jeu.getGrille(j, i).estVivante() == true){
                    nbCelluleVivante +=1;
                }
            }
        }
        System.out.println("N° de la génération : " + ANSI_YELLOW + numGeneration + ANSI_RESET);
        System.out.println("Nombre de cellule vivante : " + ANSI_GREEN + nbCelluleVivante + ANSI_RESET);
        nbCelluleVivante = 0;
    }
    
}
