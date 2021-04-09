import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.*;

public class JeuDeLaVieUI extends JFrame implements Observateur {

    private static final long serialVersionUID = 1L;

    private JeuDeLaVie jeu;

    public JeuDeLaVieUI(JeuDeLaVie jeu){
        this.jeu = jeu;

        setTitle("Jeu De La Vie");   //On donne un titre à l'application
		setSize(600,600);                  //On donne une taille à notre fenêtre
		setLocationRelativeTo(null);       //On centre la fenêtre sur l'écran
		setResizable(false);               //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix

        actualise();
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
                    g.setColor(Color.GREEN);
                    g.fillOval((x + 1)*50, (y+ 1)*50, 30, 30);
                }
            }
        }
    }


}