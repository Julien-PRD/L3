/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 10:00:36 CET 2021
*
*/

import java.util.*;

public class Glarks {

	protected int energie;
	protected CaseLibre caseCourante;

	/**
	 * Un glark possède une quantité d'énergie et une case courante (la case sur laquel le glark se trouve actullemement)
	 * @param energie Un entier qui représente l'énergie
	 * @param caseCourante La case actuel
	 */
	public Glarks(int energie, CaseLibre caseCourante){
		this.energie = energie;
		this.caseCourante = caseCourante;
	}

	/**
	 * Méthode d'acces à l'énergie d'un glark
	 * @return l'énergie du Glark
	 */
	public int getEnergie(){
		return energie;
	}

	/**
	 * Méthode d'acces en écriture qui ajoute une quantité d'énergie à l'energie actuel du glark
	 * @param i l'énergie du Glark
	 */
	public void setEnergie(int i){
		energie += i;
	}

	/**
	 * Méthode d'acces à la case courante du glark
	 * @return La case courante du glark
	 */
	public void getCaseCourante(){
		return caseCourante;
	}

	/**
	 * Méthode qui permet de changer la case courante d'un glark par une nouvelle rentrer en parametre
	 * @param Une nouvelle case de classe CaseLibre
	 */
	public void setCaseCourante(CaseLibre nouvelleCase){
		caseCourante = nouvelleCase;
	}

	/**
	 * Cette méthode fixe l'énergie du glark à zéro, et il disparais de la listeDesGlarks de la case courante
	 */
	public void meurs(){
		energie = 0;
		caseCourante.supprimerGlark(this);
	}

	/**
	 * Message envoyé par le jeu qui provoque diminution de l’énergie nécessaire au cycle, si le Glark est
	 *  épuisé, il meurt sinon il recherche sa destination; si la case retournée est différente de la classe
	 *  courante modification de la case courante (qui ensuite offre son menu au nouveau venu)
	 */
	public void vasY(){
		energie -= 5;
		if(energie==0){
			this.meurs();
		}else{
			CaseLibre CaseSuivant = trouveDestination();
			if(caseCourante.equalsTo(caseCourante)==false){
				CaseCourante.supprimerGlark(this);
				CaseCourante=caseSuivante;
				CaseCourante.menu(this);
				CaseCourante.ajouter(this);
			}
		}
	}

	/**
	 * Méthode qui détecte si il y a un blurf sur la classe courante, si oui, alors on le retire de la classe courente et
	 * le glark gagne 100 d'énergie
	 */
	public void devoreBlurf(){
		if(caseCourante.getBlurf()==true){
			caseCourante.retireBlurf();
			this.setEnergie(100);
		}
	}

	/**
	 * Ce message est envoyé par la case destination quand un glark se déplace ; le glark receveur est celui qui
	 *  mange et le paramètre est le repas ; par défaut un glark n’est pas anthropophage mais certains type le sont
	 *  (Bornés et Pirates) ; ils redéfinissent donc cette méthode.
	 */
	public void devoreGlark(){
		//rien
	}

	/**
	 * On redéfini la classe estBorn pour la passé a false car par default un Glark n'est pas un glark borne
	 * @return false
	 */
	public boolean estBorne(){
		return false;
	}

	/**
	 * Retourne la case où va se diriger le Glark
	 * @return Une CaseLibre
	 */
	public CaseLibre trouveDestination(){
		
	}
	
}