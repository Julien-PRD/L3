/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 18:16:50 CET 2021
*
*/
import java.util.*;

public class TriSelection implements StrategieTri{

	/**
	 * Méthode qui permet de trie la liste sous forme de tri par selection
	 * @param Une List
	 * @return Une List triée
	 */
	@Override
	public <T extends Comparable<T>> List<T> trie(List<T> donnees){
		String elem1 = new String();
		String elem2 = new String();
		String min = new String();
		int taille = donnees.size();
		
		for(int i = 0; i < taille -1 ; i++){
			int index = i;
			for(int j= i+1 ; j < taille ; j++){
				elem1 = (String)donnees.get(j);
				elem2 = (String)donnees.get(index);
				if(elem1.compareTo(elem2) < 0){
					index = j;
				}
			}
			min = (String)donnees.get(index);
			donnees.set(index,donnees.get(i));
			donnees.set(i,(T)min);
		}
		return donnees;
	}

}