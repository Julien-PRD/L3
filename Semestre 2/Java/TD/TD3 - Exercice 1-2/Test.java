/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Wed Jan 13 14:21:37 CET 2021
*
*/

package zoom;

public class Test {

	public static void main(String[] args){

		Cercle c1 = new Cercle(10.0);
		System.out.println("C1 : " + c1);
		c1.agrandir(2);
		System.out.println("C1 (apres agrandir(2)) : " + c1);
		c1.reduire(5);
		System.out.println("C1 (après reduire(5)) : " + c1);
		System.out.println("C1 périmetre = " + c1.perimetre());
		System.out.println("C1 surface = " + c1.surface());

		Rectangle r1 = new Rectangle(10.0,15.0);
		System.out.println("\nR1 : " + r1);
		r1.agrandir(2);
		System.out.println("R1 (apres agrandir(2)) : " + r1);
		r1.reduire(5);
		System.out.println("R1 (après reduire(5)) : " + r1);
		System.out.println("R1 périmetre = " + r1.perimetre());
		System.out.println("R1 surface = " + r1.surface());

		Cylindre cy1 = new Cylindre(10.0,20.0);
		System.out.println("\nCy1 : " + cy1);
		cy1.agrandir(2);
		System.out.println("Cy1 (apres agrandir(2)) : " + cy1);
		cy1.reduire(5);
		System.out.println("Cy1 (apres reduire(5)) : " + cy1);
		System.out.println("Cy1 surface = " + cy1.surface());
		System.out.println("Cy1 volume = " + cy1.volume());

		Sphere sp1 = new Sphere(10.0,20.0);
		System.out.println("\nSp1 : " + sp1);
		sp1.agrandir(2);
		System.out.println("Cy1 (apres agrandir(2)) : " + sp1);
		sp1.reduire(5);
		System.out.println("Sp1 (apres reduire(5)) : " + sp1);
		System.out.println("Sp1 surface = " + sp1.surface());
		System.out.println("Sp1 volume = " + sp1.volume());
		
	}
	
}