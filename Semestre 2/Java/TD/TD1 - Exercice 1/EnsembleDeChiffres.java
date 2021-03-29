/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 06 11:38:15 CET 2021
*
*/

import java.lang.Math;

public class EnsembleDeChiffres {

	private boolean present[];
	
	//Constructeur
	public EnsembleDeChiffres(){
		int i;
		boolean present[] = new boolean[10];
		for(i=0; i<3; i++){
			present[i] = true;
			System.out.println(present[i]);
		}
		System.out.println("> Fin Initialisation\n");
	}

	//Affiche l'enssemble à l'écran, sous la forme suivante : { 0 4 5 9 }
	public void afficher(EnsembleDeChiffres e){
		System.out.println("{");
		int i;
		for(i=0; i<3 ; i++){
			if(e.present[i]){
				System.out.println(i+1+" ");
			}
		}
		System.out.println("}");
	}

	//Marque la presence du chiffre i dans l'ensemble
	public void ajoute(int i){
		for(int j=0; j<10; j++){
			if(j == i){
				present[j] = true;
			}	
		}
	}
	/*
	//Marque le chiffre i comme n'étant plus dans l'enssemble
	public void retire(int i){
		for(int j=0; j<10; j++){
			if(present[j] == i && present[i] == true){	//On vérifie que i était bien présent
				present[j] = false;
			}	
		}
	}

	//Initialise au hasard l'ensemble
	/*public void tirerAuHasard(){
		
	}

	//Retourne true si le chiffre i appartient à l'ensemble flase sinon
	public boolean appartient(int i){
		for(int j=0; j<10; j++){
			if(present[j] == i){
				return true;
			}	
		}else{
			return false;
		}
	}

	//Construit et retourne un nouvel ensemble qui est le resultat de l'intersection de l'ensemble
	//	sur lequel s'applique la methode et de l'ensemble e passé en parametre
	public EnsembleDeChiffres intersectionAvec(EnsembleDeChiffres e){
		EnsembleDeChiffres res = new EnsembleDeChiffres;
		for(int j=0; j<10; j++){
			res[j] = this[i] & e[i];
		}
		return res;
	}
	*/
}