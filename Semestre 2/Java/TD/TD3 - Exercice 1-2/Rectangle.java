/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 13 13:38:30 CET 2021
*
*/

package zoom;

public class Rectangle extends ObjetGeometrique2D {

	private double largeur;
	private double longueur;

	public Rectangle(double lar, double longu){
		largeur = lar;
		longueur = longu;
	}

	public double perimetre(){
		double res;
		res = 2 * this.largeur + 2 * this.longueur;
		return res;
	}

	public String toString(){
		String res = new String();
		res = "Largeur : " + String.valueOf(largeur) + "Longueur : " + String.valueOf(longueur);
		return res;
	}

	public double surface(){
		double res;
		res = this.largeur * this.longueur;
		return res;
	}

	public void agrandir(double facteur){
		largeur = this.largeur * facteur;
		longueur = this.longueur * facteur;
	}

	public void reduire(double facteur){
		largeur = this.largeur / facteur;
		longueur = this.longueur / facteur;
	}
	
}