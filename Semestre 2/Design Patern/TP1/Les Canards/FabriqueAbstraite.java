/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 11:28:58 CET 2021
*
*/
public abstract class FabriqueAbstraite {

	/**
	 * Fourni une instance de colvert
	 * @return Un cancaneur
	 */
	public abstract Cancaneur nouveauColvert();

	/**
	 * Fourni une instance de mandarin
	 * @return Un cancaneur
	 */
	public abstract Cancaneur nouveauMandarin();

	/**
	 * Fourni une instance de canard en plastique
	 * @return Un cancaneur
	 */
	public abstract Cancaneur nouveauCanardEnPlastique();

	/**
	 * Fourni une instance de appeau
	 * @return Un cancaneur
	 */
	public abstract Cancaneur nouveauAppeau();
	
}