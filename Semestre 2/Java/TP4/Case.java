/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 09:11:37 CET 2021
*
*/
public class Case {

	protected int ligne;
	protected int colonne;

	/**
	 * C’est une classe abstraite. Elle possède deux sous-classes concrètes CaseObstacle et CaseLibre dont le seul
	 * 	comportement commun est de savoir répondre au message envoyé par les Glarks leur demandant si elles sont un obstacle.
	 * Constrcuteur, chaque case connaît sa position (ligne, colonne).
	 */
	public Case(int ligne, int colonne){
		this.ligne = ligne;
		this.colonne = colonne;
	}

	/**
	 * Une case est par default pas un obstacle.
	 */
	public boolean estObstacle(){
		return false;
	}
	
}