/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 08 10:22:35 CET 2021
*
*/
public class Test_Triangle {

	public static void main(String args[]){
		
		Point p1 = new Point(0,0);
		Point p2 = new Point(6,0);
		Point p3 = new Point(3,3);
		
		Triangle t1 = new Triangle(p1,p2,p3);
		System.out.println("T1 -> " + t1);
		System.out.println("Perimetre de T1 -> " + t1.perimetre());
		System.out.println("Surface de T1   -> " + t1.surface());
	}
	
}