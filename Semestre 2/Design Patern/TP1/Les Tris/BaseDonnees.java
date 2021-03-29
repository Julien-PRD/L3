/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 18:00:36 CET 2021
*
*/

import java.util.*;

public class BaseDonnees {

	/**
	 * Une List qui fait office de base de donnee dans cet exercice
	 */
	private ArrayList base = new ArrayList();

	/**
	 * Constructeur d'une base de donnée qui sera trie avec la stratégie de tri choisit en parametre
	 * @param Une stratégie de tri
	 */
	public BaseDonnees(StrategieTri tri){
		base.add("Barthez");base.add("Leboeuf");base.add("Thuram");base.add("Lizarazu");base.add("Desailly");base.add("Petit");base.add("Zidane");base.add("Djorkaeff");
		tri.trie(base);
	}

	/**
	 * Affichage de la base de donnée triee dans le terminal
	 */
	public void afficheDonneesTriees(){
		System.out.println(base);
	}
	
}