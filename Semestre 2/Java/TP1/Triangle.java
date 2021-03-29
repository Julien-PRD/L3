/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 08 10:20:25 CET 2021
*
*/

import java.lang.Math;

public class Triangle{

	//Un triangle est constituer de 3 points
	public Point pt1;
	public Point pt2;
	public Point pt3;

	/**
	 * Le constructeur
	 * 
	 * @param pt1
	 * 		Un point de la classe Point
	 * @param pt2
	 * 		Un point de la classe Point
	 * @param pt3
	 * 		Un point de la classe Point
	 * 		
	 */
	public Triangle(Point pt1, Point pt2, Point pt3){
		this.pt1 = pt1;
		this.pt2 = pt2;
		this.pt3 = pt3;
	}

	public String toString(){
		String res = new String();
		res = "P1 = " + pt1 + "P2 = " + pt2 + "P3 = " + pt3;
		return res;
	}

	/**
	 * La méthode prerimetre permet de calculer le périmetre d'un triangle	
	 * 
	 * @return
	 * 		Le resultat de type double
	 * 
	 */
	public double perimetre(){
		double res;
		res = this.pt1.distance(this.pt2) +
				this.pt2.distance(this.pt3) +
				this.pt3.distance(this.pt1);
		return res;
	}

	/**
	 * Cette methode calcul la surface d'un triangle avec la formule de Héron
	 * 
	 * @return
	 * 		Le resultat de type double
	 * 		
	 */
	public double surface(){
		double p = this.perimetre()/2;
		double res = res = Math.sqrt(p*(p- this.pt1.distance(this.pt2))*
										(p- this.pt2.distance(this.pt3))*
										(p- this.pt3.distance(this.pt1)));
		return res;
	}
	
}