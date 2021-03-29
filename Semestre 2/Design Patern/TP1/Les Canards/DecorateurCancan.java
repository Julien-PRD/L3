/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 11:27:32 CET 2021
*/

public abstract class DecorateurCancan implements Cancaneur {

	protected Cancaneur cancaneur;

	/**
	 * Décourateur qui permet d'ajouter des propriétés à un Cancaneur
	 * @return Un Cancaneur qui pourra avoir un décorateur
	 */
	public DecorateurCancan(Cancaneur cancaneur){
		this.cancaneur = cancaneur;
	}
	
}