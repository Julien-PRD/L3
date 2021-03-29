/**
* @author Julien PROUDY
* @version 0.1 : Date : Fri Jan 15 10:28:07 CET 2021
*
*/

public class Auteur {

	private String nom;
	private Date date_naissance;
	private Date date_deces;

	/**
	 * Constructeur d'un auteur
	 * 
	 * @param n Nom de l'auteur, un String
	 * @param naissance Date de naissance de classe Date
	 * @param deces Date de deces de classe Date
	 * 
	 * @throws InvalidDateException Si jamais jour > 31 et moi > 12.
	 * 
	 */
	public Auteur(String n, Date naissance, Date deces) throws InvalidDateException{
		if(naissance.getJour() >31){
			throw new InvalidDateException("ERROR : InvalidDateException - Jour > 31");
		}
		if(naissance.getMois() >12){
			throw new InvalidDateException("ERROR : InvalidDateException - Mois > 12");
		}
		if(deces.getJour() >31){
			throw new InvalidDateException("ERROR : InvalidDateException - Jour > 31");
		}
		if(deces.getMois() >12){
			throw new InvalidDateException("ERROR : InvalidDateException - Mois > 12");
		}
		nom = n;
		date_naissance = naissance;
		date_deces = deces;
	}

	/**
	 * Redefinition de toString
	 * 
	 * @return Une chaine de caratère qui affiche le nom de l'auteur ainsi que sa date de naissance
	 * 	avec le toString de la classe Date
	 */
	public String toString(){
		String res = new String();
		res = nom + " | " + date_naissance.toString() + " -> " + date_deces.toString();
		return res;	
	}

	/**
	 * Renvoi la date de naissance (Getter)
	 * 
	 * @return Une année
	 */
	public Date getNaissance(){
		return this.date_naissance;
	}

	/**
	 * Renvoi la date de deces (Getter)
	 * 
	 * @return Une année
	 */
	public Date getDeces(){
		return this.date_deces;
	}

	/**
	 * Renvoi le nom de l'auteur (Getter)
	 * 
	 * @return Une chaine de caratère
	 */
	public String getNom(){
		return this.nom;
	}

	/**
	 * Redefinition de la méthode equals
	 * 
	 * @param o Objet qui sert de comparable
	 * 
	 * @return true si les deux auteurs sont egaux ou false sinon
	 */
	public boolean equals(Object o){
		if(!(o instanceof Auteur)){
			return false;
		}
		Auteur a2 = (Auteur)o;

		//Si les deux auteurs sont morts
		if( (this.getNaissance().compareTo(a2.getNaissance()))==0 &&
				(this.getDeces().compareTo(a2.getDeces()))==0 &&
				(this.getNom() == a2.getNom()) ){
			return true;			
		}else{
			return false;
		}

		
		
		
	}

	
	
}