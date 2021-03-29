/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 09:04:36 CET 2021
*
*/
public class Appeau implements Cancaneur {

	/**
	 * Modification de la méthode cancaner pour s'adapter au bruit fait par le appeau
	 * @return Le bruit de l'appeau sur le terminal en chaîne de caractère
	 */
	@Override
	public void cancaner(){
		System.out.println("Couincouin");
	}
	
}