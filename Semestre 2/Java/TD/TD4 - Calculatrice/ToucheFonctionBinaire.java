/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:50 CET 2021
*
*/
public class ToucheFonctionBinaire extends ToucheFonction{

	public ToucheFonctionBinaire(String etiq, UniteCentrale uc, String fonc){
		super(etiq,uc,fonc);
	}

	public void activeToi(){
		uc.execOpBinaire(fonction);
	}
	
}