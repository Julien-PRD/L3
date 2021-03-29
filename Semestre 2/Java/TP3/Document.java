/**
* @author Julien PROUDY
* @version 0.1 : Date : Fri Jan 15 11:09:20 CET 2021
*
*/

public class Document {

	private Auteur auteur;
	private String titre;
	private boolean dispo;

	/**
	 * Constructeur d'un document
	 * 
	 * @param a L'auteur du document de classe Auteur
	 * @param t Le titre du document, une chaine de caractère
	 * @param d La disponibilité du document, true or false
	 * 
	 */
	public Document(Auteur a, String t, boolean d){
		auteur = a;
		titre = t;
		dispo = d;
	}

	/**
	 * Redefinition de toString
	 * 
	 * @return Une chaine de caratère qui affiche le nom de l'auteur, le titre du document
	 * 	et aussi sa disponibilité
	 */
	public String toString(){
		String res = new String();
		res = auteur.toString() + " - " + titre + " - Disponible?(" + String.valueOf(dispo) + ")";
		return res;
	}

	/**
	 * Renvoi l'auteur (Getter)
	 * 
	 * @return L'auteur
	 */
	public Auteur getAuteur(){
		return this.auteur;
	}

	/**
	 * Renvoi le titre (Getter)
	 * 
	 * @return Le titre
	 */
	public String getTitre(){
		return this.titre;
	}

	/**
	 * Renvoi la dsponibilité (Getter)
	 * 
	 * @return La disponibilité
	 */
	public boolean getDispo(){
		return this.dispo;
	}

	/**
	 * Redefinition de la méthode equals
	 * 
	 * @param o Objet qui sert de comparable
	 * 
	 * @return true si les deux documents sont egaux ou false sinon
	 */
	public boolean equals(Object o){
		if(!(o instanceof Document)){
			return false;
		}
		Document d2 = (Document)o;

		return ( (this.getTitre() == d2.getTitre()) &&
				(this.getAuteur().equals(d2.getAuteur())) );
	}

	/**
	 * Change la disponibilité d'un document
	 */
	public void modifStatut(){
		if(this.getDispo() == true){
			this.dispo = false;
		}else{
			this.dispo = true;
		}
	}

	
	
	
}