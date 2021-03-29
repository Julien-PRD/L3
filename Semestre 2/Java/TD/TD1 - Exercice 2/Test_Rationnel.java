/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Mon Jan 11 20:56:51 CET 2021
*
*/
public class Test_Rationnel {

	public static void main(String args[]){
		Rationnel r1 = new Rationnel(7,2);
		Rationnel r2 = new Rationnel(4,5);
		System.out.println("r1 : " + r1 + "\n");
		System.out.println("r2 : " + r2 + "\n");
		System.out.println("Numerateur      : " + r1.num());
		System.out.println("Denominateur    : " + r1.den());
		System.out.println("toDouble        : " + r1.toDouble());
		System.out.println("R1+R2           : " + r1.somme(r2));
		System.out.println("R1-R2           : " + r1.difference(r2));
		System.out.println("R1*R2           : " + r1.produit(r2));
		System.out.println("R1/R2           : " + r1.quotient(r2));
		System.out.println("CompareTo R1 R2 : " + r1.compareTo(r2));
	}
	
}