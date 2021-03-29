/**
* @author Julien PROUDY
* @version 0.1 : Date : Fri Jan 15 09:03:56 CET 2021
*
*/
public class Test {
	public static void main(String args[]){
		try{
			System.out.println("--- TEST CLASS DATE ---\n");
			Date d1 = new Date(2,4,1840);
			Date d2 = new Date(29,9,1902);
			System.out.println("D1 : " + d1);
			System.out.println("D2 : " + d2);
			System.out.println("Comparaison D1 / D2 : " + d1.compareTo(d2)+"\n");

			System.out.println("--- TEST CLASS AUTEUR ---\n");
			Auteur a1 = new Auteur("Emile Zola",d1,d2);
			Auteur a2 = new Auteur("Emile Zola",d1,d2);
			System.out.println("A1 : " + a1);
			System.out.println("A2 : " + a2);
			System.out.println("A1 = A2 ? -> " + a1.equals(a2)+"\n");

			System.out.println("--- TEST CLASS DOCUMENT ---\n");
			Document doc1 = new Document(a1,"Germinal", true);
			Document doc2 = new Document(a2,"Nana", true);
			Document doc3 = new Document(a2,"Au Bonheur des Dames", true);
			System.out.println("Doc1 : " + doc1);
			System.out.println("Doc2 : " + doc2);
			System.out.println("Doc3 : " + doc3);
			System.out.println("Doc1 = Doc2 ? -> " + doc1.equals(doc2)+"\n");

			System.out.println("--- TEST CLASS BASE DOCUMENT ---\n");
			BaseDocuments baseDoc = new BaseDocuments();
			System.out.println("Ajout de doc1, doc2 et doc1 puis affichage");
			baseDoc.ajoute(doc1);
			baseDoc.ajoute(doc2);
			baseDoc.ajoute(doc1);
			baseDoc.affiche();
			System.out.println("\nAffichage apres une suppression de doc1");
			baseDoc.supprime(doc1);
			baseDoc.affiche();
			System.out.println("\nEst ce que Doc2 est dispo ?");
			baseDoc.estDisponible(doc2);
			System.out.println("\nEmprunter Doc2 puis affichage");
			baseDoc.emprunte(doc2);
			baseDoc.affiche();
			System.out.println("\nRendre Doc2 puis affichage");
			baseDoc.rend(doc2);
			baseDoc.affiche();
			
			
		}catch(InvalidDateException e){
			System.out.println(e.getMessage());
			
		}catch(NoSuchElementException e1){
			System.out.println(e1.getMessage());
		}
	}
}