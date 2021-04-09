import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class JeuDeLaVie implements Observable{
    
    private Cellule[][] grille;
    private List<Observateur> observateurs = new ArrayList<Observateur>();
    private int xMax; //colonnes
    private int yMax; //lignes
    private List<Commande> commandes = new ArrayList<Commande>();

    public JeuDeLaVie(){
        xMax = 20;
        yMax = 20;
        grille = new Cellule[xMax][yMax];
    }

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
    }

    public int getXMax(){
        return xMax;
    }

    public int getYMax(){
        return yMax;
    }

    public Cellule getGrille(int x, int y){
        return grille[y][x];
    }

    @Override
    public void attacheObservateur(Observateur o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void detacheObservateur(Observateur o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void notifieObservateurs() {
        for(Observateur o : observateurs){
            o.actualise();
        } 
    }

    public void ajouteCommande(Commande c){
        commandes.add(c);
    }

    public void executeCommande(){
        for(Commande c : commandes){
            c.executer();
        }
        commandes.clear();
    }

}
