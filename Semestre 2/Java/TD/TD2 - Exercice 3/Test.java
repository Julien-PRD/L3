/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Jan 12 17:33:14 CET 2021
*
*/


package location;

public class Test {
	public static void main(String[] args){
		Personne p1 = new Personne("Eren",21,1350,false);
		System.out.println("P1 : "+p1);
		Personne p2 = new Personne("Armin",19,1550,true);
		System.out.println("P2 : "+p2);
		Louable v1 = new Voiture("Renault",152);
		System.out.println("V1 : "+v1);
		Chambre c1 = new Chambre(45, 70);
		System.out.println("C1 : "+c1);
		System.out.println("P1 peut louer V1 ?"+v1.peutEtreLoue(p1));
		System.out.println("P2 peut louer V1 ?"+v1.peutEtreLoue(p2));
		System.out.println("P1 peut louer C1 ?"+c1.peutEtreLoue(p1));
	}
}