/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Mon Jan 25 16:40:35 CET 2021
*
*/

package abr;

public class ArbreBinaireRecherche<E extends Comparable<E>>{

	private E valeur; 
	private ArbreBinaireRecherche<E> filsGauche;
	private ArbreBinaireRecherche<E> filsDroit;

	// Constructeur //
	
	public ArbreBinaireRecherche(E valeur){
		this.valeur = valeur;
		filsGauche = filsDroit = null;
	}

	public ArbreBinaireRecherche(E valeur, ArbreBinaireRecherche<E> g, ArbreBinaireRecherche<E> d){
		this.valeur = valeur;
		filsGauche = g;
		filsDroit = d;
	}

	// Méthodes //
	
	public E valeur(){
		return valeur;
	}

	public boolean existeFilsGauche(){
		return filsGauche != null;
	}

	public boolean existeFilsDroit(){
		return filsDroit != null;
	}

	public ArbreBinaireRecherche<E> filsGauche(){
		return filsGauche;
	}

	public ArbreBinaireRecherche<E> filsDroit(){
		return filsDroit;
	}

	public void affecterFilsGauche(ArbreBinaireRecherche<E> g){
		filsGauche = g;
	}

	public void affecterFilsDroit(ArbreBinaireRecherche<E> d){
		filsDroit = d;
	}

	public boolean contient(E x){
		if(this.valeur.equals(x)){
			return true;
		}else if(this.existeFilsDroit()){
			return this.filsDroit().contient(x);
		}else if(this.existeFilsGauche()){
			return this.filsDroit().contient(x);
		}else{
			return false;
		}
	}

	
}