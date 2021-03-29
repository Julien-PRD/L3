/**
* @author Proudy
* @version 0.1 : Date : Thu Jan 28 17:17:41 CET 2021
*
*/

import java.util.*;

public class TitreComparator implements java.util.Comparator{

	public int compare(Object o1, Object o2){
		return compare((Document) o1, (Document) o2);
	}

	private int compare (Document d1, Document d2){
		return d1.getTitre().compareTo(d2.getTitre());
	}

}