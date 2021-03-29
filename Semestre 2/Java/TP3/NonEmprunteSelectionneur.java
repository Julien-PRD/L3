/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 19 10:40:47 CET 2021
*
*/
public class NonEmprunteSelectionneur implements Selectionneur {

	/**
	 * Permet de savoir si le document est emprunter
	 * @param Un Document
	 * @return true si le document est disponible, false sinon.
	 */
	public boolean estSatisfaitPar(Document d){
		return (d.getDispo());
	}
	
}