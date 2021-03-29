/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 12 17:27:01 CET 2021
*
*/

package location;

public class Chambre implements Louable {

	private int numero;
	private int prix_location;

	public Chambre(int num, int prix){
		numero = num;
		prix_location = prix;
	}

	public String toString(){
		String res = new String();
		res = "n°"+String.valueOf(numero)+" - "+String.valueOf(prix_location)+"$";
		return res;
	}

	public float prixLocation(){
		return prix_location;
	}

	public boolean peutEtreLoue(Personne loueur){
		if(loueur.getAge() > 18 && loueur.getSalaire() > 1000 && prix_location < (200/100*loueur.getSalaire())){
			return true;
		}else{
			return false;
		}
	}
	
}