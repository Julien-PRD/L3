/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 11:44:55 CET 2021
*
*/
public class FabriqueDeCanards extends FabriqueAbstraite{

	/**
	 * Fourni une instance de colvert classique
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauColvert(){
		return new Colvert();
	}

	/**
	 * Fourni une instance de mandarin classique
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauMandarin(){
		return new Mandarin();
	}

	/**
	 * Fourni une instance de canard en plastique classique
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauCanardEnPlastique(){
		return new CanardEnPlastique();
	}

	/**
	 * Fourni une instance de appeau classique
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauAppeau(){
		return new Appeau();
	}
	
}