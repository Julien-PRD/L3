/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 17:35:28 CET 2021
*
*/

import java.util.*;

public class Troupe implements Cancaneur{

	/* Une liste qui représente une troupe de cancaneur */
	private ArrayList listCancaneurs = new ArrayList();

	/**
	 * Ajoute un cancaneur dans la liste de cancaneur (la troupe)
	 */
	public void add(Cancaneur c){
		listCancaneurs.add(c);
	}

	/**
	 * Fait cancaner toute la liste de cancaneur (fait cancaner toute la troupe)
	 */
	public void cancaner(){
		Iterator it = listCancaneurs.iterator();
		while(it.hasNext()){
			Cancaneur c = (Cancaneur)it.next();
			c.cancaner();
		}
	}
	
}