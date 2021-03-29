/**
* @author Julien PROUDY
* @version 0.1 : Date : Mon Mar 22 18:00:42 CET 2021
*
*/

public class Test {
	
	public static void main(String[] args) {

		System.out.println("\nBase de donnee :\n[Barthez, Leboeuf, Thuram, Lizarazu, Desailly, Petit, Zidane, Djorkaeff]");

		System.out.println("\n===  Tri Java  ===");
		BaseDonnees maBase = new BaseDonnees(new TriJava());
		maBase.afficheDonneesTriees();

		System.out.println("\n===  Tri Bulles  ===");
		BaseDonnees maBase2 = new BaseDonnees(new TriBulles());
		maBase2.afficheDonneesTriees();

		System.out.println("\n===  Tri Selection  ===");
		BaseDonnees maBase3 = new BaseDonnees(new TriSelection());
		maBase3.afficheDonneesTriees();

		System.out.println("\n");
	}
}