/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 12 17:19:45 CET 2021
*
*/

package location;

public class Voiture implements Louable{

	private String marque;
	private int prix_location;

	public Voiture(String marq, int prix){
		marque = marq;
		prix_location = prix;
	}

	public String toString(){
		String res = new String();
		res = marque+" - "+String.valueOf(prix_location)+"$";
		return res;
	}

	public float prixLocation(){
		return prix_location;
	}

	public boolean peutEtreLoue(Personne loueur){
		if(prix_location < loueur.getSalaire() / 2 && loueur.getPermis() == true){
			return true;
		}else{
			return false;
		}
	}
	
}