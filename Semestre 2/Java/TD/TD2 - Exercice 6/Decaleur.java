/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Jan 24 21:03:03 CET 2021
*
*/

public class Decaleur {

	private int l;
	private String(char[] decal);

	public Decaleur(int nb_caractere,char[] message){
		l = nb_caractere;
		for(int i=0;i<decal.lenght();i++){
			decal[i] = " ";
		}
	}

	public int  getLargeur(){
		return this.l;
	}

	public void raz(){
		int i;
		for(i=0;i<decal.lenght();i++){
			decal[i]=" ";
		}
	}

	public String toString(){
		String res = new String();
		int i;
		for(i=0;i<decal.lenght();i++){
			res = res + decal[i];
		}
		return res;
	}
	
}