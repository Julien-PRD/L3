/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Mar 09 14:00:01 CET 2021
*
*/

import java.util.*;
import java.util.function.ToDoubleFunction;
import static java.util.stream.Collectors.*;

public class Utils {

	/* Question 1 */
	public static List<Personne> personnesNom(String nom, List<Personne> lstPers){
		return lstPers.stream()
							.filter(p -> p.getNom().equals(nom))
							.collect(toList());		
	}

	/* Question 2 */
	public static List<Personne> personnesMajeures(List<Personne> lstPers){
		return lstPers.stream()
							.filter(p -> p.getAge() >= 18)
							.collect(toList());
	}

	/* Question 3 */
	public static boolean existeProfession(String profession, List<Personne> lstPers){
		return lstPers.stream()
							.anyMatch(p -> p.getProfession().equals(profession));
	}

	/* Question 4 */
	public static List<String> professions(List<Personne> lstPers){
		return lstPers.stream()
							.map(m -> m.getProfession())
							.distinct()
							.sorted()
							.collect(toList());
	}

	/* Question 8 */
	public static OptionalDouble moyenneAgePersonne(List<Personne> listPers){
		/*return listPers.stream()
							.mapToInt(Personne::getAge)
							.average();
		*/
		return moyenneListe(listPers, Personne::getAge);
	}

	/* Question 9 */
	public static <A> OptionalDouble moyenneListe(List <A> l, toDoubleFonction<A> extract){
		return l.stream()
					.mapToDouble(extract)
					.average();
	}

	

	
}