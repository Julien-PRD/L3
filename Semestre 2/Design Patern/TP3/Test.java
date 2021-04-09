public class Test {
    
    public static void main(String[] args) {
        JeuDeLaVie jeu = new JeuDeLaVie();
        jeu.InitialiseGrille();

        for(int i=0 ; i<20 ; i++){
            for(int j=0 ; j<20 ; j++){
                if(jeu.getGrille(j, i).estVivante() == true){
                    System.out.print(" V ");
                }else{
                    System.out.print(" M ");
                }
            }
            System.out.println("\n");
        }

        System.out.println("haut gauche - " + jeu.getGrille(0, 0).nombreVoisinesVivantes(jeu));
        System.out.println("bas gauche - " + jeu.getGrille(19, 0).nombreVoisinesVivantes(jeu));
        System.out.println("haut droite - " + jeu.getGrille(0, 19).nombreVoisinesVivantes(jeu));
        System.out.println("bas droite - " + jeu.getGrille(19, 19).nombreVoisinesVivantes(jeu));

        JeuDeLaVieUI fenetre = new JeuDeLaVieUI(jeu);
        fenetre.setVisible(true);

        while(true){
            jeu.calculerGenerationSuivante();
            System.out.println("---| GENERATION SUIVANTE |---");
            System.out.println("Cellule test : " + jeu.getGrille(10, 8).nombreVoisinesVivantes(jeu) + " voisin(s)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        

    }
}
