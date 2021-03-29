/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 09:53:00 CET 2021
*
*/
public class CompteurDeCancans extends DecorateurCancan{

	private static int nbCancans; //Commun a tous les compteurs

	public CompteurDeCancans(Cancaneur c){
		super(c);
	}

	/**
	 * Modification de la méthode cancaner avec en plus du bruit, un compteur qui est commun à tous les cancaneurs décorer du CompteurDeCanCans
	 * @return Le bruit du cancaneur sur le terminal en chaîne de caractère
	 */
	public void cancaner(){
		cancaneur.cancaner();
		nbCancans ++;
	}

	/**
	 * Savoir le nombre de Cancan d'un cancaneur
	 * @return Un entier qui correspond au nombre de cancans
	 */
	public static int getNbCancans(){
		return nbCancans;
	}
	
}