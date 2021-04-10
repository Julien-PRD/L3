public class ObservateurModeTexte implements Observateur{

    private JeuDeLaVie jeu;
    private int numGeneration;
    private int nbCelluleVivante;

    public ObservateurModeTexte(JeuDeLaVie jeu){
        this.jeu = jeu;
        numGeneration = 0;
        nbCelluleVivante = 0;

        jeu.attacheObservateur(this);      //On renseigne l'observateur au jeu

        actualise();
    }

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
        System.out.println("N° de la génération : " + numGeneration);
        System.out.println("Nombre de cellule vivante : " + nbCelluleVivante);
        nbCelluleVivante = 0;
    }
    
}
