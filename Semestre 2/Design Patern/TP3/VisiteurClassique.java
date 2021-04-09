public class VisiteurClassique extends Visiteur {

    public VisiteurClassique(JeuDeLaVie jeu) {
        super(jeu);
    }

    @Override
    public void visiteCelluleVivante(Cellule cellule) {
        if( cellule.nombreVoisinesVivantes(jeu) <2 || cellule.nombreVoisinesVivantes(jeu) > 3 ){
            jeu.ajouteCommande(new CommandeMeurt(cellule));
        }
    }

    @Override
    public void visiteCelluleMorte(Cellule cellule) {
        if(cellule.nombreVoisinesVivantes(jeu)==3){
            jeu.ajouteCommande(new CommandeVit(cellule));
        }
    }
    
}
