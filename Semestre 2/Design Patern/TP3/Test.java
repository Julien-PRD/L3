/**
 * Programme de test du jeu de la vie
 * @author Julien PROUDY
 */
public class Test {
    
    public static void main(String[] args) {
        JeuDeLaVie jeu = new JeuDeLaVie();
        jeu.InitialiseGrille();

        JeuDeLaVieUI fenetre = new JeuDeLaVieUI(jeu);
        fenetre.setVisible(true);

        new ObservateurModeTexte(jeu);

        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("          _______________________          ");
            System.out.println("_________|  GENERATION SUIVANTE  |_________");
            jeu.calculerGenerationSuivante();
            
        }
        

    }
}
