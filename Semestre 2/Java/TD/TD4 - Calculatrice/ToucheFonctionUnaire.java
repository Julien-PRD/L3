/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:40 CET 2021
*
*/
public class ToucheFonctionUnaire extends ToucheFonction{

	public ToucheFonctionUnaire(String etiq, UniteCentrale uc, String fonc){
		super(etiq,uc,fonc);
	}

	public void activeToi(){
		uc.execOpUnaire(fonction);
	}
	
}