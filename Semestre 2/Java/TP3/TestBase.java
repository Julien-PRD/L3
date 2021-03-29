/**
* @author Proudy
* @version 0.1 : Date : Tue Jan 19 11:35:37 CET 2021
*
*/

import java.util.*;

public class TestBase {
	
	public static void main(String args[]){
		try{
			Date d1 = new Date(16,1,1622);
			Date d2 = new Date(17,2,1673);
			Date d3 = new Date(2,4,1840);
			Date d4 = new Date(29,9,1902);
			Date d5 = new Date(29,10,2006);
			Auteur a1 = new Auteur("Moliere",d1,d2);
			Auteur a2 = new Auteur("Emile Zola",d3,d4);
			Auteur a3 = new Auteur("Cent Enaire",d4,d5);
			Document doc1 = new Document(a2,"Germinal", true);//1885
			Document doc2 = new Document(a2,"Nana", true);//1880
			Document doc3 = new Document(a1,"Le Malade imaginaire", true);//1673
			Document doc4 = new Document(a1,"L'Avare", true);//1668
			Document doc5 = new Document(a2,"c polymorphisme ouais", true);
			Document doc6 = new Document(a3,"a le polymorphisme", true);
			Document doc7 = new Document(a1,"b polymorphisme yes", true);
			BaseDocuments baseDoc = new BaseDocuments();
			System.out.println("---- La Base ----");
			baseDoc.ajoute(doc1);
			baseDoc.ajoute(doc2);
			baseDoc.ajoute(doc3);
			baseDoc.ajoute(doc4);
			baseDoc.ajoute(doc5);
			baseDoc.ajoute(doc6);
			baseDoc.ajoute(doc7);
			baseDoc.affiche();

			/********************************/

			System.out.println("\n---- Test Selectionneur ----");
			AuteurVivantSelectionneur aV = new AuteurVivantSelectionneur(1650);
			MotDansLeTitre mT = new MotDansLeTitre("Malade");
			MotDansLeTitre mT2 = new MotDansLeTitre("Avare");
			System.out.println("Malade dans le titre : ");
			Iterator e = baseDoc.selectionne(mT);
			while(e.hasNext()){
				System.out.println(e.next());
			}
			System.out.println("\nAuteur mort vivant en 1650 : ");
			Iterator e2 = baseDoc.selectionne(aV);
			while(e2.hasNext()){
				System.out.println(e2.next());
			}
			
			/********************************/
			
			System.out.println("\n---- Test SelectionneurComposite ----");
			SelectionneurComposite listeSelec = new SelectionneurComposite();
			listeSelec.add(mT2);
			listeSelec.add(aV);
			System.out.println("Avare dans le titre + Auteur vivant en 1650 : ");
			System.out.println("Pour doc3 - " + listeSelec.estSatisfaitPar(doc3));
			System.out.println("Pour doc4 - " + listeSelec.estSatisfaitPar(doc4));

			System.out.println("\nSelectionneurComposite Q15 : ");
			SelectionneurComposite listeSelecQ15 = new SelectionneurComposite();
			MotDansLeTitre motQ15 = new MotDansLeTitre("polymorphisme");
			AuteurVivantSelectionneur anneeQ15 = new AuteurVivantSelectionneur(2005);
			listeSelecQ15.add(motQ15);
			listeSelecQ15.add(anneeQ15);
			System.out.println("Pour doc1 - " + listeSelecQ15.estSatisfaitPar(doc1));
			System.out.println("Pour doc2 - " + listeSelecQ15.estSatisfaitPar(doc2));
			System.out.println("Pour doc6 - " + listeSelecQ15.estSatisfaitPar(doc6));
			
			/******************************/
			
			System.out.println("\n---- Test ListeTriee ----");
			Comparator comp = new TitreComparator();
			Iterator e3 = baseDoc.selectionne(motQ15);
			List lTriee = BaseDocuments.listeTriee(e3, comp);
			Iterator e4 = lTriee.iterator();
			while(e4.hasNext()){
				System.out.println(e4.next());
			}
			
		}catch(InvalidDateException e){
			System.out.println(e.getMessage());
		}
	}
}