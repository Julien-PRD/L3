/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:02 CET 2021
*
*/


public abstract class Touche {

	protected String etiquette;

	public Touche(String s){
		etiquette = s;
	}

	public abstract void activeToi();
	
}