public class Test {
    
    public static void main(String[] args) {
        JeuDeLaVie jeu = new JeuDeLaVie();
        jeu.InitialiseGrille();

        for(int i=0 ; i<jeu.getXMax() ; i++){
            for(int j=0 ; j<jeu.getYMax() ; j++){
                if(jeu.getGrille(j, i).estVivante() == true){
                    System.out.print(" V ");
                }else{
                    System.out.print(" M ");
                }
            }
            System.out.println("\n");
        }

        JeuDeLaVieUI fenetre = new JeuDeLaVieUI(jeu);
        fenetre.setVisible(true);

        while(true){
            System.out.println("          _______________________          ");
            System.out.println("_________|  GENERATION SUIVANTE  |_________");
            jeu.calculerGenerationSuivante();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        

    }
}
