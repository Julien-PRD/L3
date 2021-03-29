/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 10:00:50 CET 2021
*
*/

import java.util.*;

public class Pirate extends Glarks{

	public Pirate(int energie, CaseLibre caseCourante){
		super(energie, caseCourante);
	}

	public void devoreBlurf(){
		
	}


	public void devoreGlark(){
		this.setEnergie(repas.getEnergie());
		repas.meurs();
	}

	public CaseLibre trouveDestination(){
		
	}
	
}