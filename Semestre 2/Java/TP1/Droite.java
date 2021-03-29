/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 08 11:41:23 CET 2021
*
*/

public class Droite {

	//Un droite est définie par deux reels
	public float a; //(coefficient directeur)
	public float b; //(ordonée a l'origine)

	/**
	 * Le constructeur, representant les coefficients de l'équation de droite
	 * 	y = ax + b
	 * Permet de creer une droite a partir de deux points connus
	 * 
	 * @param p1
	 * 		Un point de la classe Point
	 * 	
	 * 	@param p2
	 * 		Un point de la classe Point
	 * 
	 */
	public Droite(Point p1, Point p2){
		a = (p2.y - p1.y) / (p2.x - p1.x);
		b = p1.y - (a*p1.x);
	}

	public String toString(){
		String res = new String();
		res = "y="+a+"x+"+b;
		return res;
	}

	/**
	 * Cette méthode permet de savoir si la droite est parralèle a la droite
	 * 	passé en parametre, pour cela on verifie que ces deux droites ont un
	 * 	coefficient directeur égal.
	 * 	
	 * 	@param d2
	 * 		Une droite de la classe Droite
	 * 		
	 * 	@return
	 * 		true si la droite est parallele a d2, false sinon
	 * 		
	 */
	public boolean estParallele(Droite d2){
		if(this.a == d2.a){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Cette methode permet de connaitre le point d'intersection de deux droites
	 * 	Elle retourne vrai si il y en a un ou false si les deux droites sont
	 * 	parallele.
	 * 	
	 * 	@param d2
	 * 		Une droite de la classe Droite
	 * 		
	 * 	@return
	 * 		
	 */
	public boolean intersection(Droite d2){
		float x;
		float y;
		if(this.estParallele(d2)){
			System.out.println("Les deux droites sont paralleles !\n");
			return false;
		}else{
			x = (d2.b - this.b) / (d2.a - this.a);
			y = this.a * x + this.b;
			Point inter = new Point(x,y);
			System.out.println("\nPoint d'intersection I" + inter);
			return true;
		}
	}
	
}