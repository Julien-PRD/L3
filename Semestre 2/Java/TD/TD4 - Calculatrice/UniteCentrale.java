/**
* @author Proudy
* @version 0.1 : Date : Fri Jan 22 15:30:24 CET 2021
*/

import java.lang.*;
import java.util.*;

public class UniteCentrale {

	private Stack pile;
	private Ecran ecran;

	public UniteCentrale(){
		pile = new Stack();
		ecran = new Ecran(this);
	}

	public Ecran getEcran(){
		return ecran;
	}
	
	public void execOpUnaire(String f){
		int i;
		int res = 1;
		int nbr = ecran.getBuffer();
		switch(f){
			case "facto":
				for(i=1; i<= nbr ; i++){
					res = res * i;
				}
				ecran.setBuffer(res);
				validation();
				ecran.afficher(String.valueOf(res));
				break;
			default :
				System.out.println("Erreur, opérande est inconnue\n");
				break;
		}
		
	}

	public void execOpBinaire(String f){
		int gauche = Integer.parseInt((String)pile.pop());
		int droite = ecran.getBuffer();
		int res = 0;
		switch(f){
			case "plus":
				res = gauche + droite;
				break;
			case "moins":
				res = gauche - droite;
				break;
			case "multi":
				res = gauche * droite;
				break;
			case "divi":
				res = gauche / droite;
				break;
			default:
				System.out.println("Erreur, opérande est inconnue\n");
				break;
		}
		ecran.setBuffer(res);
		validation();
		ecran.afficher(String.valueOf(res));
		
	}

	public void clear(){
		pile.clear();
		ecran.afficher("0");
	}

	public void validation(){
		ecran.recouvrir();
	}

	public void metsDansPile(String s){
		pile.push(s);
	}
	
}