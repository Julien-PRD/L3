/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:30 CET 2021
*
*/
public class ToucheFonctionSpeciale extends ToucheFonction{

	public ToucheFonctionSpeciale(String etiq, UniteCentrale uc, String fonc){
		super(etiq,uc,fonc);
	}

	public void activeToi(){
		switch(fonction){
			case "init":
				uc.clear();
				break;
			case "validation":
				uc.validation();
				break;
			default:
				System.out.println("Erreur fonction");
		}
	}
	
}