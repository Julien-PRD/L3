public class Test {
    
    public static void main(String[] args) {
        JeuDeLaVie jeu = new JeuDeLaVie();
        jeu.InitialiseGrille();

        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                if(jeu.getGrille(i, j).estVivante() == true){
                    System.out.print(" V ");
                }else{
                    System.out.print(" M ");
                }
            }
            System.out.println("\n");
        }

        System.out.println(jeu.getGrille(1, 1).nombreVoisinesVivantes(jeu));

    }

}
