/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 06 10:18:53 CET 2021
*
*/
public class Generateur{

	private Filtre premierFiltre;

	public String toString(){
		String res = "La liste des nombres premiers generés est :" + premierFiltre ;
		return res;
	}

	public Generateur(){
		premierFiltre = new Filtre(2);
	}

	public void lanceToi(int unNombre){
		int i;
		for(i=2 ; i < unNombre ; i++){
			premierFiltre.aToiDeTraiter(i);
		}
	}
	
}