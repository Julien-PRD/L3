import java.util.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

public class Interface extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel texteNom = new JLabel("Nom ");
    JTextField zoneNom = new JTextField();

    JLabel zoneVide1 = new JLabel("                          ");
    JButton boutonConnexion = new JButton("Connexion");
    boolean estConnecter = false;

    JLabel texteIP = new JLabel("IP      ");
    JTextField zoneIP = new JTextField();

    JLabel textePort = new JLabel("Port");
    JLabel zoneVide2 = new JLabel("                              ");
    JTextField zonePort = new JTextField();

    JLabel texteConnectes = new JLabel("Connectés");
    JTextPane zoneConnectes = new JTextPane();

    JLabel texteDiscussion = new JLabel("Discussion");
    JTextPane chatDiscussion = new JTextPane();
    JScrollPane zoneDiscussion = new JScrollPane(chatDiscussion);
    SimpleAttributeSet style_normal = new SimpleAttributeSet();
    SimpleAttributeSet style_user = new SimpleAttributeSet();
    SimpleAttributeSet style_connection = new SimpleAttributeSet();

    StyledDocument doc = chatDiscussion.getStyledDocument();

    JLabel texteMessage = new JLabel("Message");
    JTextPane chatMessage = new JTextPane();
    JScrollPane zoneMessage = new JScrollPane(chatMessage);

    JButton boutonEnvoyer = new JButton("Envoyer");

    JPanel panelTop = new JPanel();
    JPanel panelGauche = new JPanel();
    JPanel panelDroit = new JPanel();

    JPanel panelNomConnection = new JPanel();
    JPanel panelIpPort = new JPanel();

    JPanel panelNomConnectes = new JPanel();
    JPanel panelZoneConnectes = new JPanel();
    JPanel subPanelDroit = new JPanel();

    JPanel panelNomDiscussion = new JPanel();
    JPanel panelZoneDiscussion = new JPanel();

    JPanel panelNomMessage = new JPanel();
    JPanel panelZoneMessage = new JPanel();

    JPanel panelBoutonEnvoyer = new JPanel();

    JTextField nomUtilisateur = new JTextField(20);
    JTextField iPUtilisateur = new JTextField(20);
    JTextField portUtilisateur = new JTextField(20);

    User currentUser = new User("","",0);

    int currentPort;
    String userName = new String();
    String userIP = new String();
    int userPort;
    //String userList = new String();
    String userMessage = new String();

    Socket socket;
    DataInputStream userInput;
    PrintStream theOutputStream;
    InputStream inputstream;
    InputStreamReader inputstreamreader;
    BufferedReader bufferedreader;

    List<String> userList = new ArrayList<>();


    public Interface() {

        super("Chat TP5 Java - Julien PROUDY");
        this.setSize(500, 600); // Largeur - Hauteur
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /* Un ligne grise qui sera autour des différents panneaux */
        Border ligneGrise = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        /* On ajoutes les bordures grises autours des conteneurs */
        zoneNom.setBorder(ligneGrise);
        zoneIP.setBorder(ligneGrise);
        zonePort.setBorder(ligneGrise);
        zoneMessage.setBorder(ligneGrise);
        zoneConnectes.setBorder(ligneGrise);

        /* Initalisation des différents éléments de l'interface graphique */
        zoneNom.setPreferredSize(new Dimension(120, 20));
        zoneNom.getDocument().addDocumentListener(new TexteListener(zoneNom, zoneIP, zonePort, boutonConnexion));
        zoneIP.setPreferredSize(new Dimension(120, 20));
        zoneIP.getDocument().addDocumentListener(new TexteListener(zoneNom, zoneIP, zonePort, boutonConnexion));
        zonePort.setPreferredSize(new Dimension(120, 20));
        zonePort.getDocument().addDocumentListener(new TexteListener(zoneNom, zoneIP, zonePort, boutonConnexion));

        /* Initialisation du bouton de connexion */
        boutonConnexion.setPreferredSize(new Dimension(160, 20)); 
        boutonConnexion.setEnabled(false);                          //Par défault (au lancement du programme), le bouton est désactivé
        boutonConnexion.addActionListener(new Bouton_Connexion());  //On ajoute l'"action" que fait le bouton

        /* Initialisation du panneaux avec la liste des utilisateurs connectés */
        zoneConnectes.setPreferredSize(new Dimension(150, 420));
        zoneConnectes.setEditable(false);                           //Cette zone ne sera pas editable par l'utilisateur

        /* Initialisation du panneaux avec le chat entre les utilisateurs, ce panneaux affiche les méssages qui sont envoyé */
        chatDiscussion.setPreferredSize(new Dimension(260, 250));
        chatDiscussion.setEditable(false);                          //Cette zone ne sera pas editable par l'utilisateur

        /* Initialisation de la zone où l'utilisateur écrit le méssage qu'il souhaite envoyer */
        zoneMessage.setPreferredSize(new Dimension(260, 90));

        /* Initialisation du bouton d'envoie de message */
        boutonEnvoyer.setPreferredSize(new Dimension(260, 25));
        boutonEnvoyer.addActionListener(new Bouton_Envoyer());      //On ajoute l'"action" que fait le bouton

        /*************************************************************************************************/
        /* --------------------- Initialisation des tailles des différents panneaux --------------------- */
        /*************************************************************************************************/

        panelTop.setPreferredSize(new Dimension(100, 100));

        panelGauche.setPreferredSize(new Dimension(200, 100));
        panelDroit.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));

        panelDroit.setPreferredSize(new Dimension(300, 275));
        panelDroit.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));

        /*************************************************************************************************/
        /* --------------------- ZONE DU HAUT (Nom / IP / Port / Bouton Connexion) --------------------- */
        /*************************************************************************************************/

        panelTop.setLayout(new BorderLayout());

        panelNomConnection.add(texteNom);
        panelNomConnection.add(zoneNom);
        panelNomConnection.add(zoneVide1);
        panelNomConnection.add(boutonConnexion);
        panelNomConnection.setPreferredSize(new Dimension(100, 50));

        panelIpPort.add(texteIP);
        panelIpPort.add(zoneIP);
        panelIpPort.add(zoneVide2);
        panelIpPort.add(textePort);
        panelIpPort.add(zonePort);
        panelIpPort.setPreferredSize(new Dimension(100, 50));

        panelTop.add(panelNomConnection, BorderLayout.NORTH);
        panelTop.add(panelIpPort, BorderLayout.SOUTH);

        /*************************************************************************************************/
        /* --------------------- ZONE GAUCHE (La liste des utilisateurs connectés) --------------------- */
        /*************************************************************************************************/
        panelGauche.setLayout(new BorderLayout());

        panelNomConnectes.add(texteConnectes);
        panelNomConnectes.setPreferredSize(new Dimension(150, 30));

        panelZoneConnectes.add(zoneConnectes);
        panelZoneConnectes.setPreferredSize(new Dimension(150, 100));

        panelGauche.add(panelNomConnectes, BorderLayout.NORTH);
        panelGauche.add(panelZoneConnectes, BorderLayout.CENTER);
        
        /************************************************************************************************/
        /* ---------- ZONE DROITE (Zone de discussion / Ecriture du message / Bouton envoyé) ---------- */
        /************************************************************************************************/

        /* Création d'un paneau et d'un sous panneau, le sous panneau sert a placer le texte "message" la zone d'écriture du méssage et le bouton envoyer */
        panelDroit.setLayout(new BorderLayout());
        subPanelDroit.setLayout(new BorderLayout());

        /* Ajout du texte "discussion" sur le panneau du même nom, on initialise également sa taille idéale */
        panelNomDiscussion.add(texteDiscussion);
        panelNomDiscussion.setPreferredSize(new Dimension(150, 30));

        /* Ajout de la zone de discussion sur le panneau du même nom, on initialise également sa taille idéale */
        panelZoneDiscussion.add(zoneDiscussion);
        panelZoneDiscussion.setPreferredSize(new Dimension(150, 100));

        /* Initialisation du style (police) dans la zone de discusion */
        StyleConstants.setFontFamily(style_normal, "Calibri");
        StyleConstants.setFontSize(style_normal, 14);

        /* Initialisation de la police d'écriture pour le nom de l'utilisateur dans la zone de discusion */
        style_user.addAttributes(style_normal);
		StyleConstants.setForeground(style_user, Color.BLUE);
		StyleConstants.setUnderline(style_user, true);
		StyleConstants.setFontSize(style_user, 14);
		StyleConstants.setBold(style_user, true);

        style_connection.addAttributes(style_normal);
        StyleConstants.setForeground(style_connection, Color.GRAY);
		StyleConstants.setFontSize(style_connection, 10);
        StyleConstants.setItalic(style_connection, true);

        panelNomMessage.add(texteMessage);
        panelNomMessage.setPreferredSize(new Dimension(150, 30));

        panelZoneMessage.add(zoneMessage);
        panelZoneMessage.setPreferredSize(new Dimension(150, 100));

        panelBoutonEnvoyer.add(boutonEnvoyer);
        panelBoutonEnvoyer.setPreferredSize(new Dimension(150, 30));

        subPanelDroit.add(panelNomMessage, BorderLayout.NORTH);
        subPanelDroit.add(panelZoneMessage, BorderLayout.CENTER);
        subPanelDroit.add(panelBoutonEnvoyer, BorderLayout.SOUTH);

        panelDroit.add(panelNomDiscussion, BorderLayout.NORTH);
        panelDroit.add(panelZoneDiscussion, BorderLayout.CENTER);
        panelDroit.add(subPanelDroit, BorderLayout.SOUTH);

        /************************************************************************************************/
        /* ------------------- Ajout de tous les panneaux dans le paneaux principal ------------------- */
        /************************************************************************************************/

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelGauche, BorderLayout.CENTER);
        this.add(panelDroit, BorderLayout.EAST);

        panelGauche.setVisible(false);
        panelDroit.setVisible(false);

        /* Préramplir des zones pour les tests */
        //zoneNom.setText("Julien");
        zonePort.setText("44000");
        //zoneIP.setText("192.168.1.30");
        
        this.setVisible(true);  //Toujour rendre visible la fenetre

        /************************************************************************************************/
        /* ------------------------ Gestion des messages reçu par le serveur ----------------------- */
        /************************************************************************************************/

        while(true){
            try {
                try {
                    //Eviter de faire "trop" tourner la boucle while
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(estConnecter==true){ //On verifie que l'utilisateur est bien connecter
                    String reponse;
                    while((reponse = bufferedreader.readLine()) != null){
                        try {
                            /*Les messages qui sont envoyer et recu ont un "code" du style ":connexion: -!- Julien"
                            * On va donc les couper en plusieurs morceaus avec "split" et les ranger dans un tableau
                            * pour facilite le traitement.
                            */
                            String[] arr_Message = reponse.split("-!-");

                            System.out.println("Message recu : " + arr_Message[0]);

                            /* TRAITEMENT DES MESSAGES */
                            if(arr_Message[0].contains(":message:")){  
                                doc.insertString(doc.getLength(), arr_Message[1], style_user);
                                doc.insertString(doc.getLength(), " : " + arr_Message[2] + "\n", style_normal);
                            
                            /* TRAITEMENT DES CONNEXIONS */ 
                            }else if(arr_Message[0].contains(":connexion:")){
                                System.out.println("Contenu recu : " + arr_Message[1]);;
                                zoneConnectes.setText(arr_Message[1]);  //Problème avec le saut de ligne

                            /* TRAITEMENT DES DECONNEXIONS */    
                            }else if(arr_Message[0].contains(":deconnexion:")){
                                System.out.println("Contenu recu : " + arr_Message[1]);;
                                zoneConnectes.setText(arr_Message[1]);
                            }

                        } catch (Exception e) {
                            //TODO: handle exception
                        }
                    }
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
				
        }

    }

    /************************************************************************************************/
    /* ---------------------------- Instructions des différents boutons --------------------------- */
    /************************************************************************************************/

    /**
    * La classe qui permet de donner au bouton de connexion des instructions 
    */
    class Bouton_Connexion implements ActionListener {

        /**
        * Cette methode va permettre de faire une suite d'instrcution lorsque le bouton est enclencher
        * @param e Une action
        * @return void
        */
        public void actionPerformed(ActionEvent e) {
            if (estConnecter == false) {
                userName = zoneNom.getText();
                userIP = zoneIP.getText();
                userPort = Integer.parseInt(zonePort.getText());

                currentUser = new User(userName,userIP,userPort);

                zoneNom.setEditable(false);
                zoneIP.setEditable(false);
                zonePort.setEditable(false);

                panelGauche.setVisible(true);
                panelDroit.setVisible(true);

                boutonConnexion.setText("Deconnexion");
                boutonConnexion.setEnabled(true);

                /* CONNEXION AU SERVEUR */
                try {
                    socket = new Socket(userIP, userPort);
                    PrintWriter out = new PrintWriter(socket.getOutputStream());

                    /* On envoit au serveur l'instruction que l'utilisateur vient de se connecter avec la balise "connexion", on renseigne également son nom */
                    out.println(":connexion: -!- " + userName);
                    out.flush();

                    /* On initalise les différentes variables qui permettent la lecture coté client */
                    inputstream = socket.getInputStream();
                    inputstreamreader = new InputStreamReader(inputstream);
                    bufferedreader = new BufferedReader(inputstreamreader);

                    try{
                        doc.insertString(doc.getLength(), "Vous etes connecte" + "\n", style_connection);
                        System.out.println("Vous etes connecté !");
                        estConnecter = true;
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                }catch (Exception e2) {
                    e2.printStackTrace();
                }

            }else{  //estConnecter == TRUE

                estConnecter = false;   //Le statut de l'utilisateur actuel change
                
                /* On vide les conteneurs du nom, de l'IP et du Port */
                zoneNom.setText("");
                zoneIP.setText("");
                zonePort.setText("");

                /* Le bouton qui était alors de connexion  */
                boutonConnexion.setText("Connexion");
                boutonConnexion.setEnabled(false);

                /* On cache les panneaux de droite et de gauche, la liste des connectés et la zone de chat */
                panelGauche.setVisible(false);
                panelDroit.setVisible(false);

                /* Les zones pour se connecter sont de nouveaux réeditable */
                zoneNom.setEditable(true);
                zoneIP.setEditable(true);
                zonePort.setEditable(true);

                /* On envoit au serveur l'instruction que l'utilisateur vient de se deconnecter avec la balise "deconnexion" */
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.println(":deconnexion: -!- " + userName);
                    out.flush();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        }
    }

    /**
    * La classe qui permet de donner au bouton d'envoie de message des instructions 
    */
    class Bouton_Envoyer implements ActionListener {

        /**
        * Cette methode va permettre de faire une suite d'instrcution lorsque le bouton est enclencher
        * @param e Une action
        * @return void
        */
        public void actionPerformed(ActionEvent e) {
            userMessage = chatMessage.getText();
            chatMessage.setText("");

            /* On envoit au serveur l'instruction que l'utilisateur vient d'envoyer un message avec la balise "message", on renseigne également son nom */
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(":message: -!- " + userName + " -!- " + userMessage );
                out.flush();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            

        }
    }

    /************************************************************************************************/
    /* ------------------------- Verifications de remplissage des champs -------------------------- */
    /************************************************************************************************/

    /**
    * La classe qui permet de verifier si les champs "nom", "ip" et "port" sont bien remplis
    */
    class TexteListener implements DocumentListener {

        private JTextField texteNom;
        private JTextField texteIP;
        private JTextField textePort;
        private JButton boutonConnexion;
    
        /**
        * Ce construteur va permettre d'initialiser les différents elements a surveiller
        * @param texteNom Le nom de l'utilisateur
        * @param texteIP L'IP de l'utilisateur
        * @param textePort Le port de l'utilisateur
        * @param boutonConnexion Le bouton de connexion
        */
        public TexteListener(JTextField texteNom, JTextField texteIP, JTextField textePort, JButton boutonConnexion){
            this.texteNom = texteNom;
            this.texteIP = texteIP;
            this.textePort = textePort;
            this.boutonConnexion = boutonConnexion;
        }
    
        @Override
        public void insertUpdate(DocumentEvent e) {
            actualise();
        }
    
        @Override
        public void removeUpdate(DocumentEvent e) {
            actualise();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            actualise();
        }
        
        /**
        * Cette methode va permettre de faire les tests n
        * @return void
        */
        private void actualise(){
            if( !texteNom.getText().trim().equals("") && !texteIP.getText().trim().equals("") && !textePort.getText().trim().equals("") ){
                boutonConnexion.setEnabled(true);
            }else{
                boutonConnexion.setEnabled(false);
            }
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

}

