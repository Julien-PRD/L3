/**
* @author Julien PROUDY
* @version 0.1 : Date : Fri Jan 15 08:57:18 CET 2021
*
*/
public class Date implements java.lang.Comparable {

	private int jour;
	private int mois;
	private int annee;

	/**
	 * Constructeur d'une date
	 * 
	 * @param j Le jour sous forme d'entier
	 * @param m Le moi sous forme d'entier
	 * @param a L'annee sous forme d'entier
	 * 
	 * @throws InvalidDateException Si jamais jour > 31 et moi > 12.
	 * 
	 */
	public Date(int j, int m, int a) throws InvalidDateException{
		if(j >31){
			throw new InvalidDateException("ERROR : InvalidDateException - Jour > 31");
		}
		if(m >12){
			throw new InvalidDateException("ERROR : InvalidDateException - Mois > 12");
		}
		jour = j;
		mois = m;
		annee = a;
	}

	/**
	 * Redefinition de toString
	 * 
	 * @return Une chaine de caratère qui affiche une date JJ/MM/AAAA
	 */
	public String toString(){
		String res = new String();
		res = String.valueOf(jour) + "/" + String.valueOf(mois) + "/" + String.valueOf(annee);
		return res;
	}

	/**
	 * Renvoi l'année de la date (Getter)
	 * 
	 * @return L'année
	 */
	public int getAnnee(){
		return this.annee;
	}

	/**
	 * Renvoi le moi de la date (Getter)
	 * 
	 * @return Le moi
	 */
	public int getMois(){
		return this.mois;
	}

	/**
	 * Renvoi le jour de la date (Getter)
	 * 
	 * @return Le jour
	 */
	public int getJour(){
		return this.jour;
	}

	/**
	 * Redefinition de la méthode compareTo
	 * 
	 * @param o Un object, ici ce sera une date a comparer
	 * 
	 * @return nul si c'est les dates sont égales
	 * @return negatif si d < o
	 * @return positif si d > o
	 */
	public int compareTo(Object o){
		if((this.getAnnee() - ((Date)o).getAnnee()) != 0){
			return this.getAnnee()-((Date)o).getAnnee();
		}else{
			if((this.getMois() - ((Date)o).getMois())!= 0){
				return this.getMois() - ((Date)o).getMois();
			}else{
				return this.getJour() - ((Date)o).getJour();
			}
		}
	}
	
}