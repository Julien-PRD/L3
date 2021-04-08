import java.awt.Graphics;

import javax.swing.JFrame;

public class JeuDeLaVieUI extends JFrame implements Observateur {

    private static final long serialVersionUID = 1L;

    private JeuDeLaVie jeu;

    public JeuDeLaVieUI(JeuDeLaVie jeu){
        this.jeu = jeu;
        this.setSize(500, 600); // Largeur - Hauteur
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actualise() {
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        for(int x=0 ; x<jeu.getXMax() ; x++){
            for( int y=0 ; y < jeu.getYMax() ; y++){
                if(jeu.getGrille(x, y).estVivante()){
                    g.fillOval(x*3, y*3, 3, 3);
                }
            }
        }
    }

    public void Interface(){
        this.setSize(500, 500); // Largeur - Hauteur
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);  //Toujour rendre visible la fenetre
    }

}
