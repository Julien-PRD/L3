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

        if(jeu.getGrille(y-1, x-1).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y, x-1).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y+1, x-1).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y-1, x).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y+1, x).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y-1, x+1).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y, x+1).estVivante() == true){
            nombreVoisinesVivantes ++;
        }
        if(jeu.getGrille(y+1, x+1).estVivante() == true){
            nombreVoisinesVivantes ++;
        }

        return nombreVoisinesVivantes;
    }

}