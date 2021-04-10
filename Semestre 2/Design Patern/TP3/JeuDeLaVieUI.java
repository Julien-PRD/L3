import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.*;

/**
 * Cette classe représente l'interface graphique du jeu de la vie
 * @author Julien PROUDY
 */
public class JeuDeLaVieUI extends JFrame implements Observateur {

    private static final long serialVersionUID = 1L;

    private JeuDeLaVie jeu;

    /*************************************/
    /* VARIABLE POUR INTERFACE GRAPHIQUE */
    /*************************************/
    private JPanel pan = new JPanel();
    Icon icon = new ImageIcon("assets/icone_pause.PNG");
    private JButton bouton1 = new JButton(icon);                        //Bouton pour exécuter/arrêter la boucle d’exécution
    boolean enPause;
    private JButton bouton2 = new JButton("Avancer d'une génération");  //Bouton pour avancer d’une génération lorsque la boucle est arrêtée
    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 100);                             //Slider pour ajuster la vitesse de la boucle d’exécution
    String[] nomRegles = new String[] {"Classique", "Day And Night","High Life"};
    private JComboBox<String> choixRegle = new JComboBox<>(nomRegles);  //Contrôle de sélection des règles du jeu

    /**
     * Constructeur de l'interface graphique d'un jeu de la vie, on initialise également la fenêtre d'affichage.
     * @param jeu Le jeu de la vie qui benificiera de l'interface graphique
     */
    public JeuDeLaVieUI(JeuDeLaVie jeu){
        this.jeu = jeu;

        setTitle("Jeu De La Vie");         //On donne un titre à l'application
		setSize(750,800);                  //On donne une taille à notre fenêtre
		setLocationRelativeTo(null);       //On centre la fenêtre sur l'écran
		setResizable(false);               //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix

        pan.add(bouton1);
        bouton1.addActionListener(new Bouton_Pause());
        
        enPause = false;

        bouton2.setEnabled(false);
        bouton2.addActionListener(new Bouton_GenerationSuivante());
        pan.add(bouton2);

        slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
        slider.setMajorTickSpacing(200); 
        slider.setMinorTickSpacing(200); 
        slider.addChangeListener(new ChangeListener(){ 
            @Override
            public void stateChanged(ChangeEvent e) {
                jeu.setVitesse(slider.getValue());
            }
        });
        pan.add(slider);

        pan.add(choixRegle);
        setContentPane(pan);

        setVisible(true);


        jeu.attacheObservateur(this);   //On renseigne l'observateur au jeu
        jeu.setUI(this);
        actualise();                    //Affichage de l'état de base
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
                    g.fillOval((x + 2)*15, (y+ 7)*15, 5, 5);
                }
            }
        }
    }

    class Bouton_Pause implements ActionListener {

        /**
        * Cette methode va permettre de faire une suite d'instrcution lorsque le bouton est enclencher
        * @param e Une action
        * @return void
        */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(enPause == false){
                bouton1.setIcon(new ImageIcon("assets/icone_marche.PNG"));
                bouton2.setEnabled(true);
                enPause = true;
            }else if(enPause == true){
                bouton1.setIcon(new ImageIcon("assets/icone_pause.PNG"));
                bouton2.setEnabled(false);
                enPause = false;
            }
        }
    }

    public boolean getPause(){
        return enPause;
    }

    class Bouton_GenerationSuivante implements ActionListener {

        /**
        * Cette methode va permettre de faire une suite d'instrcution lorsque le bouton est enclencher
        * @param e Une action
        * @return void
        */
        @Override
        public void actionPerformed(ActionEvent e) {
            jeu.avancerUneGeneration();
        }
    
    }

}


