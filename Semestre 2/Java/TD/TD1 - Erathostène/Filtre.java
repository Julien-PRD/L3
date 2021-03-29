/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 06 10:18:59 CET 2021
*
*/

public class Filtre {

	public int valeur;
	public Filtre suivant;

	public String toString(){
		String res = String.valueOf(valeur)+";";
		if(suivant!=null){
			res+=suivant.toString();
		}
		return res;
	}

	public Filtre(int valeur){
		valeur = valeur;
		suivant = null;
	}

	public boolean aToiDeTraiter(int unNombre){
		StringBuffer chaine = new StringBuffer();
		chaine.append(unNombre);
		if(unNombre==valeur){
			chaine.append(" est premier");
			System.out.println(chaine.toString());
			return true;
		}else{
			if(unNombre % valeur == 0){
				chaine.append( " n'est pas premier");
				System.out.println(chaine.toString());
				return false;
			}else{
				if(suivant != null){
					return suivant.aToiDeTraiter(unNombre);
				}else{
					chaine.append(" est premier");
					System.out.println(chaine.toString());
					suivant = new Filtre(unNombre);
					return true;
				}
			}
		}
	}
	
}