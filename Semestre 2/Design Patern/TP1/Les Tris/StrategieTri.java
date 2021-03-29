/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 17:59:58 CET 2021
*
*/
import java.util.List;

public interface StrategieTri {

	/**
	 * La méthode qui permet de trie la liste, elle sera implémenter dans chaque stratégie (bulles, selection et java)
	 * @param Une List
	 * @return Une List triée
	 */
	<T extends Comparable<T>> List<T> trie(List<T> donnees);
	
}