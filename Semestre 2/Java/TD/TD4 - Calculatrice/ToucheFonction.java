/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:19 CET 2021
*
*/
public abstract class ToucheFonction extends Touche{

	protected String fonction;
	protected UniteCentrale uc;

	public ToucheFonction(String e, UniteCentrale uc, String fonc){
		super(e);
		fonction = fonc;
		this.uc = uc;
	}
	
}