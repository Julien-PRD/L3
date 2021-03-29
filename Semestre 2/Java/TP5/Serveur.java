import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Serveur {
   
   private int port;
   private List<String> userList = new ArrayList<>();
   private ArrayList<Socket> clients = new ArrayList<>(); 
   int idClient;
   int i;

   public Serveur(int port){
      this.port = port;
   }

   public static void main(String[] args) throws IOException {
      new Serveur(44000).run();
   }

	public void run() { 
		try {
			ServerSocket ss = new ServerSocket(44000); //Création du serveur
			while(true) {				
				Socket socket = ss.accept(); //Controle de la connexion
				System.out.println("Un client vient de se connecter");
				clients.add(socket);
				++idClient;
				new Conversation(socket, idClient).start(); //Création d'une nouvelle conversation entre tous les utilisateurs, debut de l'instanciation
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Cette classe devra être instancié, pour chaque client connecté. Si non, on pourrait pas se connecter à plusieurs en même temps sur le serveur.
	 */
	class Conversation extends Thread { 
		
		private Socket socket;
		private int idClient;
		
		public Conversation(Socket socket, int idClient) {
			this.socket = socket;
			this.idClient = idClient;
		}
		
		@Override
		public void run() { // On redifinit la méthode
			try {

				/* Grâce à l’objet InputStream et OutputStream nous allons pouvoir écouter les flux entrant et sortant.
				* InputStream et OutputStream communique par 4 octets. Soit un caractère.
				*/
				InputStream inputstream = socket.getInputStream();
				InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
				BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
				OutputStream outputstream = socket.getOutputStream();

				/* Nous écrivons donc dans le flux sortant. Pour ce faire nous allons utiliser l’objet PrintWriter. */
				PrintWriter printWriter = new PrintWriter(outputstream, true);
				
				printWriter.println("Bienvenue vous etes le client " + idClient);
				
				String ip = socket.getRemoteSocketAddress().toString();
				System.out.println("Connexion avec l'ip : " + ip);
				
				/*Nous allons maintenant écouter quand un client envoi un message. On doit faire deux boucles dont une infinie.
				* La première écoutera en permanence les nouveaux messages.
				* La seconde est là pour vérifier que le message n’est pas égal à Null.
				*/
				while(true) {
					String request;
					while((request = bufferedreader.readLine()) != null) {	

						if(request.contains(":connexion:")){ //connexion
							String[] arr_request = request.split("-!-"); // Séraration pour recuperer que le nom de l'utilisateur qui se connecte
							userList.add(arr_request[1]); //Ajout dans la liste

							System.out.println("nb Element dans la liste : " + userList.size());

							/* Actualisation de la liste des connecters et ajout dans le requete envoyer par le serveur */
							for(i=0; i<userList.size()-1;i++){
								System.out.println("LISTE DES UTILISATEURS  : " + userList.get(i));
								request =  request + userList.get(i);
								request = request + "\n";
							}

							System.out.println("Req : " + request + " finReq");;
							broadCast(request);	//Envoi de la requete a tous les utlisateurs connectés
							System.out.println(" - - - - - - - - - - - - - - - - ");

						}else if(request.contains(":deconnexion:")){ //deconnexion 
							String[] arr_request_deco = request.split("-!-"); // Séraration pour recuperer que le nom de l'utilisateur qui se deconnecte

							userList.remove(arr_request_deco[1]);	//On retire l'utilisateur qui vient de se déconnecter

							System.out.println("Req : " + request + " finReq");;

							broadCast(request); //Envoi de la requete a tous les utlisateurs connectés
							System.out.println(" - - - - - - - - - - - - - - - - ");

						}else if(request.contains(":message:")){ //message 
							System.out.println("Req : " + request + " finReq");;

							broadCast(request); //Envoi de la requete a tous les utlisateurs connectés
							System.out.println(" - - - - - - - - - - - - - - - - ");

						}
					}							
				}
			}catch (IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
    * Cette methode va permettre d'envoyer un message a tout les utlisateurs connectés
    * @param message Le message qui sera envoyer
    * @return void
    */
	public void broadCast(String message) {
		for(Socket client : clients) {
			try {
				PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
				printWriter.println(message); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

		
}


