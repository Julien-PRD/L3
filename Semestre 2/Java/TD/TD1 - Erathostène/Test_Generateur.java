/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 06 11:21:35 CET 2021
*
*/

public class Test_Generateur {

	public static void main (String args[]){
		int leNombre = 12;
		Generateur leGene = new Generateur();
		leGene.lanceToi(leNombre);
		System.out.println(leGene);
	}
	
}