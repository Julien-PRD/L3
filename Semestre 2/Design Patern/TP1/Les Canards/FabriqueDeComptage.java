/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 11:47:36 CET 2021
*
*/
public class FabriqueDeComptage extends FabriqueAbstraite{

	/**
	 * Fourni une instance de colvert enveloppé dans un CompteurDeCancans
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauColvert(){
		return new CompteurDeCancans(new Colvert());
	}

	/**
	 * Fourni une instance de mandarin enveloppé dans un CompteurDeCancans
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauMandarin(){
		return new CompteurDeCancans(new Mandarin());
	}

	/**
	 * Fourni une instance de canard en plastique enveloppé dans un CompteurDeCancans
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauCanardEnPlastique(){
		return new CompteurDeCancans(new CanardEnPlastique());
	}

	/**
	 * Fourni une instance de appeau enveloppé dans un CompteurDeCancans
	 * @return Un cancaneur
	 */
	@Override
	public Cancaneur nouveauAppeau(){
		return new CompteurDeCancans(new Appeau());
	}
	
}