/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 18:16:34 CET 2021
*
*/
import java.util.*;

public class TriJava implements StrategieTri{

	/**
	 * Méthode qui permet de trie la liste sous forme de tri avec l'interface Collections (Collections.sort())
	 * @param Une List
	 * @return Une List triée
	 */
	@Override
	public <T extends Comparable<T>> List<T> trie(List<T> donnees){
		Collections.sort(donnees);
		return donnees;
	}
	
}