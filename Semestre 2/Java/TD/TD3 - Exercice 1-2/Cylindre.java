/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 13 13:47:33 CET 2021
*
*/

package zoom;

import java.lang.Math;

public class Cylindre extends ObjetGeometrique3D {

	private double r;
	private double h;

	public Cylindre(double rayon, double hauteur){
		r = rayon;
		h = hauteur;
	}

	public String toString(){
		String res = new String();
		res = "Rayon = " + String.valueOf(r) + " | Hauteur = " + String.valueOf(h);
		return res;
	}

	public double surface(){
		double res;
		res = 2*Math.PI*this.r*this.h;
		return res;
	}

	public double volume(){
		double res;
		res = Math.PI*Math.pow(this.r,2)*this.h;
		return res;
	}

	public void agrandir(double facteur){
		r = r * facteur;
		h = h * facteur;
	}

	public void reduire(double facteur){
		r = r / facteur;
		h = h / facteur;
	}

}