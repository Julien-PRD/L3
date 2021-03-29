/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 13 13:47:38 CET 2021
*
*/

package zoom;

public class Sphere extends ObjetGeometrique3D{

	private double r;
	private double h;

	public Sphere(double rayon, double hauteur){
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
		res = 4*Math.PI*Math.pow(this.r,2);
		return res;
	}

	public double volume(){
		double res;
		res = (4*Math.PI*Math.pow(this.r,3))/3;
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