/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:30:49 CET 2021
*
*/

import java.lang.*;
import java.util.*;

public class Ecran {

	private String buffer;
	private boolean indicateur;
	private UniteCentrale uc;

	public Ecran(UniteCentrale uc){
		indicateur=false;
		buffer=new String();
		this.uc=uc;
	}

	public int getBuffer(){
		return Integer.parseInt(buffer);
	}

	public void setBuffer(int val){
		buffer = String.valueOf(val);
	}

	public void saisie(String nb){
		if(indicateur==false){
			buffer = buffer + nb;
		}else{
			uc.metsDansPile(buffer);
			buffer=nb;
			indicateur = false;
		}
		afficher(buffer);
	}

	public void recouvrir(){
		indicateur = true;
	}
	
	public void afficher(String unNombre){
		System.out.println(unNombre);
	}

	public int valeur(){
		return Integer.parseInt(buffer);
	}
	
}