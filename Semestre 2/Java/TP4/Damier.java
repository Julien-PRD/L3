/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 09:05:12 CET 2021
*
*/
public class Damier {

	private Case[][] damier;

	/**
	 * Un tableau à double entrée de cases qui ne fait rien de plus que d’assurer les services d’un tableau à double entrée.
	 * 
	 */
	public Damier(int ligne, int colonne){
		damier = new Case[ligne][colonne];
	}

	/**
	 * Retourne la case de la ième ligne et j ième colonne du damier
	 * @param i La ligne
	 * @param j La colonne
	 * @return Une Case
	 */
	public Case donneTaCase(int i, int j){
		return damier[i][j];
	}

	/**
	 * Remplace par uneCase la case de la ième ligne et j ième colonne du damier.
	 * @param i La ligne
	 * @param j La colonne
	 */
	public void modifieTaClasse(int i, int j, Case uneCase){
		damier[i][j] = uneCase; 
	}

}