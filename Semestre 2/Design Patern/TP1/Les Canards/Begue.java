/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 10:09:36 CET 2021
*
*/
public class Begue extends DecorateurCancan{

	public Begue(Cancaneur c){
		super(c);
	}

	/**
	 * Modification de la méthode cancaner avec en plus du bruit, un second bruit pour simuler le fait qu'un cancaneur soit begue (repeter 2 fois la meme chose)
	 * @return LLe bruit en double du cancaneur sur le terminal en chaîne de caractère
	 */
	public void cancaner(){
		cancaneur.cancaner();
		cancaneur.cancaner();
	}
	
}