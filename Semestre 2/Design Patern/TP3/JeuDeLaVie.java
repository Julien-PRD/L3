import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un automate cellulaire, le jeu de la vie
 * @author Julien PROUDY
 */
public class JeuDeLaVie implements Observable{
    
    private Cellule[][] grille;
    private List<Observateur> observateurs = new ArrayList<Observateur>();
    private int xMax; //colonnes
    private int yMax; //lignes
    private List<Commande> commandes = new ArrayList<Commande>();
    private VisiteurClassique visiteurClassique;
    private JeuDeLaVieUI jeuUI;
    //private VisiteurHighLife visiteurHighLife;
    //private VisiteurDayAndNight visiteurDayAndNight;

    private boolean marche;
    private int vitesse;

    /**
     * Constructeur d'un jeu de la vie, avec sa dimension et l'initalisation des différents design patern qui permettent le bon fonctionnement de l'automate
     */
    public JeuDeLaVie(){
        xMax = 45;
        yMax = 45;
        grille = new Cellule[xMax][yMax];
        visiteurClassique = new VisiteurClassique(this);
        //visiteurHighLife = new VisiteurHighLife(this);
        //visiteurDayAndNight = new VisiteurDayAndNight(this);

        marche = false;
        vitesse = 500;
    }

    /**
     * Initalisation de la grille du jeu de la vie, à partir de ses dimensions en x et y, on place aléatoirement des cellules mortes et vivantes dans la grilles avec
     *  une probabilité de 50/50.
     */
    public void InitialiseGrille(){
        double rand;
        for(int i=0 ; i<xMax ; i++){
            for(int j=0 ; j<yMax ; j++){
                rand = Math.random();
                if(rand > 0.5){
                    grille[j][i] = new Cellule(i, j, CelluleEtatVivant.getInstance());
                }else{
                    grille[j][i] = new Cellule(i, j, CelluleEtatMort.getInstance());
                }
            }
        }
        System.out.println("          _______________________          ");
        System.out.println("_________|  GENERATION INITIALE  |_________");
    }

    
    /** 
     * Permet de connaitre la taille maximal de la grille en x, c'est à dire son nombre de colonnes
     * @return Le nombre de colonnes de la grille
     */
    public int getXMax(){
        return xMax;
    }

    
    /** 
     * Permet de connaitre la taille maximal de la grille en y, c'est à dire son nombre de lignes
     * @return Le nombre de lignes de la grille
     */
    public int getYMax(){
        return yMax;
    }

    
    /** 
     * Méthode qui permet de récuperer, sur la grille, une cellule avec des données précises
     * @param x Sa position en x
     * @param y Sa posotion en y
     * @return La cellule à la position souhaitée
     */
    public Cellule getGrille(int x, int y){
        return grille[y][x];
    }

    
    /** 
     * Ajoute un observateur dans la liste des observateurs du jeu
     * @param o L'observateur à ajouter
     */
    @Override
    public void attacheObservateur(Observateur o) {
        observateurs.add(o);
    }

    /** 
     * Retire un observateur dans la liste des observateurs du jeu
     * @param o L'observateur à retirer
     */
    @Override
    public void detacheObservateur(Observateur o) {
        observateurs.remove(o);
    }

    public void setUI(JeuDeLaVieUI jeuUI){
        this.jeuUI = jeuUI;
    }

    /**
     * Actualise tous les observateurs du jeu
     */
    @Override
    public void notifieObservateurs() {
        for(Observateur o : observateurs){
            o.actualise();
        } 
    }
    
    /** 
     * Ajout d'une commande dans la liste des commandes à éxécuter dans le jeu
     * @param c La commande à ajouter
     */
    public void ajouteCommande(Commande c){
        commandes.add(c);
    }

    /**
     * Exécute toutes les commandes de la liste des commandes
     */
    public void executeCommande(){
        for(Commande c : commandes){
            c.executer();
        }
        commandes.clear();
    }

    /**
     * Invoque la méthode accepte de toutes les cellules, lesquelles invoquent la méthode accepte de leur état (délégation)
     */
    public void distribueVisiteur(){
        for(int i=0 ; i<xMax ; i++){
            for(int j=0 ; j<yMax ; j++){
                //grille[j][i].accepte(visiteurClassique);
                //grille[j][i].accepte(visiteurHighLife);
                grille[j][i].accepte(visiteurClassique);
            }
        }
    }

    /**
     * La méthode cfait avancer l’automate d’une génération en trois étapes :
     *  1. distribuer un visiteur
     *  2. exécuter les commandes
     *  3. actualiser les observateurs
     */
    public void calculerGenerationSuivante(){
        System.out.println("          _______________________          ");
        System.out.println("_________|  GENERATION SUIVANTE  |_________");
        distribueVisiteur();
        executeCommande();
        notifieObservateurs();   
    }

    public void boucleGenerationSuivante(){
        while(true){
            marche = jeuUI.getPause();
            if(marche == false){
                try {
                    Thread.sleep(vitesse);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                calculerGenerationSuivante();
            }else{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
        }
    }

    public void modifMarche(){
        if(marche == true){
            marche = false;
        }else{
            marche = true;
        }
    }

    public void avancerUneGeneration(){
        calculerGenerationSuivante();
    }

    public void setVitesse(int v){
        vitesse = v;
    }

}
