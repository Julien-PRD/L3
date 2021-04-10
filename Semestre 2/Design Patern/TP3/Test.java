/**
 * Programme de test du jeu de la vie
 * @author Julien PROUDY
 */
public class Test {
    
    public static void main(String[] args) {
        JeuDeLaVie jeu = new JeuDeLaVie();
        jeu.InitialiseGrille();

        new JeuDeLaVieUI(jeu);

        new ObservateurModeTexte(jeu);

        jeu.boucleGenerationSuivante();

    }
}
