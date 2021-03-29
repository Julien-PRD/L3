/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 09:36:09 CET 2021
*
*/
public class AdapteurDOie implements Cancaneur {

	private Oie oie;

	/**
	 * Création d'un adaptateur qui permet à l'oie d'obtenir le statut et les caractéristiques (méthodes) des Cancaneurs 
	 * @return Une oie qui aura les caractéristiques d'un Cancaneur 
	 */
	public AdapteurDOie(Oie o){
		this.oie = o;
	}

	/**
	 * Modification de la méthode cancaner pour faire cancaner les nouveaux Cancaneur
	 * @return Le bruit du canard adapter sur le terminal en chaîne de caractère
	 */
	public void cancaner(){
		oie.cacarder();
	}
	
}