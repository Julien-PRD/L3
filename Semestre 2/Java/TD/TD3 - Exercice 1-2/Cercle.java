/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 13 13:38:24 CET 2021
*
*/

package zoom;

public class Cercle extends ObjetGeometrique2D{

	private double r;

	public Cercle(double rayon){
		r = rayon;
	}

	public String toString(){
		String res = new String();
		res = "Rayon : " + String.valueOf(r);
		return res;
	}

	public double perimetre(){
		double res;
		res = 2 * Math.PI * this.r;
		return res;
	}

	public double surface(){
		double res;
		res = Math.PI * Math.pow(this.r,2);
		return res;
	}

	public void agrandir(double facteur){
		this.r = this.r * facteur;
	}

	public void reduire(double facteur){
		this.r = this.r / facteur;
	}
	
}