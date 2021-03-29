/**
* @author Proudy
* @version 0.1 : Date : Thu Jan 28 15:40:52 CET 2021
*
*/

import java.util.*;

public class SelectionneurComposite implements Selectionneur{

	private List selecComposite;

	public SelectionneurComposite(){
		selecComposite = new ArrayList();
	}

	public void add(Selectionneur s){
		selecComposite.add(s);
	}

	public boolean estSatisfaitPar(Document d){
		Iterator e = selecComposite.iterator();
		Selectionneur selec;
		while(e.hasNext()){
			selec = (Selectionneur)e.next();
			if(selec.estSatisfaitPar(d)==false){
				return false;
			}
		}
		return true;
	}
	
}