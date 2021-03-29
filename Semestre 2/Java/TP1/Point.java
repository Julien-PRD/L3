/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 08 09:07:51 CET 2021
*
*/

import java.lang.Math;

public class Point {

	//Valeurs réelles
	public float x;
	public float y;

	/**
	 * Le constructeur
	 * 
	 * @param x
	 * 		Les coordonnées en x
	 * @param y
	 * 		Les coordonnées en y
	 * 
	 */
	public Point(float x, float y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		String res = new String();
		res = "(" + x + ";" + y + ")";
		return res;
	}

	/**
	 * <p>Redifinition de la methode equals, permet de comparer 2 points de retourne
	 * 	true si ils sont identiques, false sinon.</p>
	 * 	
	 * 	@param o
	 * 		L'object (le point) a comparer avec celui existant.
	 * 		
	 * 	@return
	 * 		True ou False en fonction du resultats
	 * 	
	 */
	public boolean equals(Object o){
		if(!(o instanceof Point)){
			return false;
		}

		Point point = (Point)o;

		return x == point.x && y == point.y;
		
	}

	/**
	 * La methode distance permet de calculer la distance qui sépare la distance
	 * 	entre deux points
	 * 	
	 * 	@param p2
	 * 		p2 est l'autre point pour faire le calcul 
	 * 	
	 * 	@return
	 * 		La distance entre p1 et p2 en double car c'est le type de sqrt
	 * 		
	 */
	public double distance(Point p2){ 	
	 	double res;
		res = Math.sqrt(Math.pow(p2.x-this.x,2)+Math.pow(p2.y-this.y,2));
		return res;
	}


	/**
	 * Methode qui permet de savoir si un point se trouve sur la droite d
	 * 	On verifie qu'en remplacant x et y dans l'équation, on peut resoudre
	 * 	l'équation obtenu.
	 * 
	 * @param d
	 * 		La droite de classe Droite
	 * 		
	 * 	@return
	 * 		true si le point est sur la droite d, false sinon
	 */
	public boolean estSurDroite(Droite d){
		if( this.y == d.a * this.x + d.b){
			return true; 
		}else{
			return false;
		}
	}
	
	
}