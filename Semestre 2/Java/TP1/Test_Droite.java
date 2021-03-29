/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 08 14:53:41 CET 2021
*
*/
public class Test_Droite {

	public static void main(String args[]){
		
		Point a = new Point(-2,1);
		Point b = new Point(3,-1);
		Point c = new Point(8,10);
		
		System.out.println("A"+a);
		System.out.println("B"+b);
		System.out.println("C"+c);
		
		Droite d1 = new Droite(a,b);
		System.out.println("\nD1 avec A et B : " + d1);
		Droite d2 = new Droite(a,c);
		System.out.println("D1 avec A et C : " + d2);

		System.out.println("\nLe point B est sur D1 ? " + b.estSurDroite(d1));
		System.out.println("Le point C est sur D1 ? " + c.estSurDroite(d1));

		System.out.println("\nD1 est parallele à D2 ? " + d1.estParallele(d2));

		d1.intersection(d2);
		
		
	}
	
}