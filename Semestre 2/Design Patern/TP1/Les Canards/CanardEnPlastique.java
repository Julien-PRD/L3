/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 09:04:31 CET 2021
*
*/
public class CanardEnPlastique implements Cancaneur {

	/**
	 * Modification de la méthode cancaner pour s'adapter au bruit fait par le Canard En Plastique
	 * @return Le bruit du Canard En Plastique sur le terminal en chaîne de caractère
	 */
	@Override
	public void cancaner(){
		System.out.println("Couic");
	}
	
}