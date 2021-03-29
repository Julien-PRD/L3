/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 12 17:09:15 CET 2021
*
*/
package location;

public class Personne {

	private String nom;
	private int age;
	private int salaire;
	private boolean permis;

	public Personne(String n, int a, int s, boolean p){
		nom = n;
		age = a;
		salaire = s;
		permis = p;
	}

	public String toString(){
		String res = new String();
		res = nom + " - " + String.valueOf(age) + "ans - " + String.valueOf(salaire) + "$ - Permis?" + String.valueOf(permis);
		return res;
	}

	public String getNom(){
		return nom;
	}

	public int getAge(){
		return age;
	}

	public int getSalaire(){
		return salaire;
	}

	public boolean getPermis(){
		return permis;
	}
}