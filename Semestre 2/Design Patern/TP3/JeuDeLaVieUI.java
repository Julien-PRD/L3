import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.*;

/**
 * Cette classe représente l'interface graphique du jeu de la vie
 * @author Julien PROUDY
 */
public class JeuDeLaVieUI extends JFrame implements Observateur {

    private static final long serialVersionUID = 1L;

    private JeuDeLaVie jeu;

    /**
     * Constructeur de l'interface graphique d'un jeu de la vie, on initialise également la fenêtre d'affichage.
     * @param jeu Le jeu de la vie qui benificiera de l'interface graphique
     */
    public JeuDeLaVieUI(JeuDeLaVie jeu){
        this.jeu = jeu;

        setTitle("Jeu De La Vie");         //On donne un titre à l'application
		setSize(750,750);                  //On donne une taille à notre fenêtre
		setLocationRelativeTo(null);       //On centre la fenêtre sur l'écran
		setResizable(false);               //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix

        jeu.attacheObservateur(this);      //On renseigne l'observateur au jeu

        actualise();                       //Affichage de l'état de base
    }

    /**
     * Actualisation de l'interface graphique
     */
    @Override
    public void actualise() {
        repaint();
    }

    /**
     * Dessin de l'interface graphique
     * @param g L'interface
     */
    public void paint(Graphics g){
        super.paint(g);
        for(int x=0 ; x<jeu.getXMax() ; x++){
            for( int y=0 ; y < jeu.getYMax() ; y++){
                if(jeu.getGrille(x, y).estVivante()){
                    g.setColor(Color.darkGray);
                    g.fillOval((x + 2)*22, (y+ 2)*22, 10, 10);
                }
            }
        }
    }


}
