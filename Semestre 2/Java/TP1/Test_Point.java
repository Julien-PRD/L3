/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 08 09:16:55 CET 2021
*
*/

public class Test_Point {

	public static void main(String args[]){
		Point p1 = new Point(1,2);
		Point p2 = new Point(4,3);
		
		System.out.println("P1" + p1);
		System.out.println("P2" + p2);
		
		System.out.println("Les Points P1 et P2 sont egaux ? -> " + p1.equals(p2));
		
		System.out.println("" + p1.distance(p2));

	}
	
}