/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:09 CET 2021
*
*/

public class ToucheNumerique extends Touche {

	//private String etiquette;
	private Ecran ecran;

	public ToucheNumerique(String s, Ecran e){
		super(s);
		ecran = e;
	}

	public void activeToi(){
		ecran.saisie(etiquette);
	}
	
}