/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Sun Jan 24 21:53:16 CET 2021
*
*/
public class Test {

	public static void main (String[] args){
		Afficheur afficheur = new Afficheur(6);
		char[m] message = {'t','e','s','t'};
		afficheur.setMessage(message);
		for(int i=0;i<10;i++){
			afficheur.top();
			System.out.println("<<"+afficheur+">>");
		}
	}
	
}