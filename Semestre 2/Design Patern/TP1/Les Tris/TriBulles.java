/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 18:16:43 CET 2021
*
*/
import java.util.*;

public class TriBulles implements StrategieTri{

	/**
	 * Méthode qui permet de trie la liste sous forme de tri à bulles
	 * @param Une List
	 * @return Une List triée
	 */
	@Override
	public <T extends Comparable<T>> List<T> trie(List<T> donnees){
		String elem1 = new String();
		String elem2 = new String();
		String tmp = new String();
		int taille = donnees.size();

		for(int i=0; i< taille ;i++){
			for(int j=1; j< (taille-i) ; j++){
				elem1 = (String)donnees.get(j-1);
				elem2 = (String)donnees.get(j);
				if(elem1.compareTo(elem2) > 0){
					tmp = (String)donnees.get(j-1);
					donnees.set(j-1,donnees.get(j));
					donnees.set(j,(T)tmp);
				}
			}
		}

		return donnees;
		
	}

}