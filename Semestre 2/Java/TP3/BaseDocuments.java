/**
* @author Julien PROUDY
* @version 0.1 : Date : Fri Jan 15 11:50:53 CET 2021
*
*/

import java.util.*;

public class BaseDocuments{

	private List listeDoc;

	public BaseDocuments(){
		listeDoc= new ArrayList();
	}
	
	/** ajoute un document dans la base de documents
	* @param d le document `a ajouter
	*/
	public void ajoute(Document d){
		listeDoc.add(d);
	}

	/** supprime un document de la base de documents (si il est plusieurs
	* fois présents, une seule des occurrences est supprimée). Il
	* importe peu que le document soit emprunté ou non ,au moment de sa
	* suppression.
	* @param d le document à supprimer
	* @return le document supprimé, null s’il n’existe pas
	*/
	public Document supprime(Document d){
		Document doc_suppr; //Le document de retour (le document qui sera supprimer)
		if(!listeDoc.contains(d)){
			return null; //pas de document		
		}else{
			doc_suppr = d;
			listeDoc.remove(d);
			return doc_suppr;
		}
	}

	/** affiche tous les documents de la mediathèque (pour impression
	* du catalogue par exemple)
	*/
	public void affiche(){
		//System.out.println(listeDoc);
		Iterator e = listeDoc.iterator();
		while(e.hasNext()){
			System.out.println(e.next());
		}
	}

	/** indique si le document donné est disponible (non emprunté)
	* @param d le document concerné
	* @return true si le document donné est disponible (non emprunté)
	* @exception NoSuchElementException si le document n’existe
	* pas dans la mediathèque
	*/
	public boolean estDisponible(Document d) throws NoSuchElementException{
		if(!listeDoc.contains(d)){
			throw new NoSuchElementException("ERROR NoSuchElementException - Le document n'est pas present dans la liste");
		}else{
			if(d.getDispo() == true){
				System.out.println(d.toString() + " est disponible");
			}else{
				System.out.println(d.toString() + " n'est pas disponible");
			}
			return d.getDispo();
		}
	}
	
	/** permet d’emprunter un document
	* @param d le document concerne
	* @exception NoSuchElementException si le document n’existe
	* pas dans la mediathèque
	*/
	public void emprunte(Document d) throws NoSuchElementException{
		if(!listeDoc.contains(d)){
			throw new NoSuchElementException("ERROR NoSuchElementException - Le document n'est pas present dans la liste");
		}else{
			if(d.getDispo() == false){
				System.out.println(d.toString()+" est deja emprunté");
			}else{
				d.modifStatut();
			}
		}
	}
	
	/** permet de rendre un document
	* @param d le document concerné
	*/
	public void rend(Document d) throws NoSuchElementException{
		if(!listeDoc.contains(d)){
			throw new NoSuchElementException("ERROR NoSuchElementException - Le document n'est pas present dans la liste");
		}else{
			if(d.getDispo() == true){
				System.out.println(d.toString()+" est deja rendu");
			}else{
				d.modifStatut();
			}
		}
	}

	/**
	 * Retourne un itérateur sur la collection des documents de la base
	 * 	de documents qui satisfont le sélectionneur s.
	 * 	
	 * 	@param Un selectionneur
	 * 	@return L'itérateur sur la collection
	 * 	
	 */
	public Iterator selectionne(Selectionneur s){
		Iterator e = listeDoc.iterator();
		List listeDocSatisfait = new ArrayList();
		Document doc;
		while(e.hasNext()){
			doc = (Document)e.next();
			if(s.estSatisfaitPar(doc)){
				listeDocSatisfait.add(doc);
			}
		}
		Iterator e2 = listeDocSatisfait.iterator();
		return e2;
	}

	/**
	 * Retourne une liste triée avec un comparateur.
	 * 
	 * @param c Un comparateur
	 * @param i Des éléments de l'itérateur
	 * @return Une liste triée
	 */
	public static List listeTriee(Iterator i, Comparator c){
        List listeDocTriee = new ArrayList();
        Document doc;
        while(i.hasNext()){
            doc = (Document)i.next();
            listeDocTriee.add(doc);
        }
        Collections.sort(listeDocTriee,c);
        return listeDocTriee;
    }
	
}