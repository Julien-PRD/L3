/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 19 10:46:05 CET 2021
*
*/
public class MotDansLeTitre implements Selectionneur {

	private String mot = new String();

	/**
	 * Constructeur qui permet de rentrer un mot sous forme de chaine
	 * 	de caratère
	 * @param Une chaine de caractère
	 */
	public MotDansLeTitre(String s){
		mot = s;
	}

	/**
	 * On verifie qu'un mot spécifier dans le contructeur est
	 * 	present dans le titre du document
	 * @param Un document
	 * @return True si le mot est present dans le titre, false sinon
	 */
	public boolean estSatisfaitPar(Document d){
		return(d.getTitre().indexOf(mot)!=-1);
	}
	
}