/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Jan 24 21:17:16 CET 2021
*
*/

public class Afficheur {

	private int n;
	private Decaleur decal;

	public Afficheur(int nb_caract){
		n = nb_caract;
	}

	public void setMessage(char[] message){
		decal = new Decaleur(n,message);
	}

	public void top(){
		
	}

	public String toString(){
		
	}
}