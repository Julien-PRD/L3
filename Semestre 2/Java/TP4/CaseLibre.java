/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 09:17:48 CET 2021
*
*/

import java.util.*;

public class CaseLibre extends Case {

	/**
	 * Elle dispose de champs supplémentaires
	 *  - damier qui permet d’accéder au damier
	 *  - blurf qui est indique la présence d’un tas de blurf
     *  - listeDesGlarks qui donne la liste des glarks présents sur la case
	 */
	private Damier damier;
	private boolean blurf;
	private List listeDeGlarks;

	/**
	 * Même constrcuteur que la classe Case, mais on ajoute un Damier
	 */
	public CaseLibre(int ligne, int colonne, Damier damier){
		super(ligne, colonne);
		this.damier = damier;
		this.listeDeGlarks = new ArrayList();
		if((int)Math.random()*(2-0))==0){
			blurf=false;
		}else{
			blurf=true;
		}
	}

	/**
	 * Supprime le blurf de la case.
	 */
	public void supprimerBlurf(){
		if( blurf == true ){
			blurf = false;
		}else{
			blurf = true;
		}
	}

	/**
	 * Supprime un Glark de la liste de glark de la case.
	 * @param glark le glark a supprimer
	 */
	public void supprimerGlark(Glarks glark){
		listeDeGlarks.remove(glark);
	}

	/**
	 * Ajoute un Glark de la liste de glark de la case.
	 * @param glark le glark a supprimer
	 */
	public void ajouter(Glarks glark){
		listeDeGlarks.add(glark);
	}

	/**
	 * Méthode d'acces aux cases voisines d'une case
	 * @param direction La direction de recherche
	 * @return Une case
	 */
	public Case getVoisin(Direction direction){
	
	}

	/**
	 * Offre au glark passé en paramètre de manger le blurf (s’il y en a), de manger les glarks présents (s’il y en a).
	 * @param glark Un glark
	 */
	public void menu(Glark glark){
		if(getBlurf()==true){
			glark.devoreBlurf();
		}
		Iterator e = listeDeGlarks.iterator();
		while(e.hasNext()){
			glark.devoreGlark(e.next());
		}
	}

	/**
	 * Méthode d'accès au damier (getter)
	 * @return Le damier
	 */
	public Damier getDamier(){
		return damier;
	}

	/**
	 * Méthode d'accès au blurf (getter)
	 * @return L'état du blurf (true ou false)
	 */
	public boolean getBlurf(){
		return blurf;
	}

	/**
	 * Méthode d'accès à la liste des Glarks (getter)
	 * @return la liste des glarks (true ou false)
	 */
	public List getListeDeGlarks(){
		return listeDeGlarks;
	}

	/**
	 * Une case libre n'est pas un obstacle.
	 * @return false
	 */
	public boolean estObstacle(){
		return false;
	}
}