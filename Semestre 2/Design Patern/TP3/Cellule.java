/**
 * Cette classe représente une cellule qui fait partie du jeu de la vie, on retrouve ses caractéritiques et son état
 * @author Julien PROUDY
 */
public class Cellule{

    private CelluleEtat etat;
    private int x;
    private int y;

    /**
     * Declaration d'une cellule, qui possède une position en 'x' et 'y' dans la grille du jeu, elle est également défini par un état (vivant ou mort)
     * @param x La position de la cellule en x
     * @param y La position de la cellule en y
     * @param etat L'état actuel de la cellule
     */
    public Cellule(int x, int y, CelluleEtat etat){
        this.x = x;
        this.y = y;
        this.etat = etat;
    }

    /**
     * Changement d'état de la cellule, la cellule est 'vivante'
     */
    public void vit(){
        etat = etat.vit();
    }
    
    /**
     * Changement d'état de la cellule, la cellule est 'morte'
     */
    public void meurt(){
        etat = etat.meurt();
    }
    
    /**
     * Connaitre l'état de la cellule
     * @return Un boolean, 'true' si la cellule est vivante, 'false' sinon
     */
    public boolean estVivante(){
        return etat.estVivante();
    }

    /**
     * Calcule le nombre de voisin vivante d'une cellule, on fait attention au cas où la cellule est sur le bord de la grille
     * @param jeu Le jeu de la vie dans laquel la cellule fait partie
     * @return Un entier représentant le nombre de cellules voisines vivantes
     */
    public int nombreVoisinesVivantes(JeuDeLaVie jeu){
        int nombreVoisinesVivantes = 0;

        if( ( y-1 >=0 && y-1 < jeu.getYMax() ) && ( x-1 >= 0 && x-1 < jeu.getXMax() ) && ( jeu.getGrille(y-1, x-1).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y >=0 && y < jeu.getYMax() ) && ( x-1 >= 0 && x-1 < jeu.getXMax() ) && ( jeu.getGrille(y, x-1).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y+1 >=0 && y+1 < jeu.getYMax() ) && ( x-1 >= 0 && x-1 < jeu.getXMax() ) && ( jeu.getGrille(y+1, x-1).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y-1 >=0 && y-1 < jeu.getYMax() ) && ( x >= 0 && x < jeu.getXMax() ) && ( jeu.getGrille(y-1, x).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y+1 >=0 && y+1 < jeu.getYMax() ) && ( x >= 0 && x < jeu.getXMax() ) && ( jeu.getGrille(y+1, x).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y-1 >=0 && y-1 < jeu.getYMax() ) && ( x+1 >= 0 && x+1 < jeu.getXMax() ) && ( jeu.getGrille(y-1, x+1).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y >=0 && 1 < jeu.getYMax() ) && ( x+1 >= 0 && x+1 < jeu.getXMax() ) && ( jeu.getGrille(y, x+1).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }
        if( ( y+1 >=0 && y+1 < jeu.getYMax() ) && ( x+1 >= 0 && x+1 < jeu.getXMax() ) && ( jeu.getGrille(y+1, x+1).estVivante() == true ) ){
            nombreVoisinesVivantes ++;
        }

        return nombreVoisinesVivantes;
    }

    /**
     * Permet à la cellule d'accepter un visiteur afin de lui laisser la responsabilité du traitement de son état futur
     * @param visiteur Le visiteur
     * @see Visiteur
     * @see VisiteurConcret
     */
    public void accepte(Visiteur visiteur){
        etat.accepte(visiteur, this);
    }

}