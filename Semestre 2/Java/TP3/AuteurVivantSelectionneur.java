/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 19 10:43:33 CET 2021
*
*/

import java.util.Comparator;

public class AuteurVivantSelectionneur implements Selectionneur {

	private int annee;

	/**
	 * Constructeur qui permet a l'utilisateur de renter une annee
	 * @param Un entier (année)
	 */
	public AuteurVivantSelectionneur(int a){
		annee = a;
	}

	/**
	 * Permet de savoir si l’auteur était encore vivant à une année donnée
	 * @param Un Document
	 * @return True si l'auteur était vivant, false sinon.
	 */
	public boolean estSatisfaitPar(Document d){
		Auteur aut = d.getAuteur();
		int date_mort = aut.getDeces().getAnnee();
		int date_naissance = aut.getNaissance().getAnnee();
		//System.out.println(date_mort);
		if(date_mort != 0){
			return((annee >= date_naissance)&&(annee<=date_mort));
		}else{
			return((annee>=date_naissance));
		}
		
	}
	
}