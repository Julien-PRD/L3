public class Cellule{

    private CelluleEtat etat;
    private int x;
    private int y;

    public Cellule(int x, int y, CelluleEtat etat){
        this.x = x;
        this.y = y;
        this.etat = etat;
    }

    public void vit(){
        etat.vit();
    }

    public void meurt(){
        etat.meurt();
    }
    
    public boolean estVivante(){
        return etat.estVivante();
    }

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

    public void accepte(Visiteur visiteur){
        etat.accepte(visiteur, this);
    }

}