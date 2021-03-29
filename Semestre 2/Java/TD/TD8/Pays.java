/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Mar 09 13:31:35 CET 2021
*
*/

import java.util.*;
import static java.util.stream.Collectors.*;

public class Pays {
    private String nom;
    private List<Ville> villes;
    
    public Pays(String nom) {
        super();
        this.nom = nom;
        villes = new ArrayList<Ville>();
    }
    
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @return the villes
     */
    public List<Ville> getVilles() {
        return villes;
    }
    
    public void ajouteVille(Ville v){
        this.villes.add(v);
    }

    /* Question 5 */
    /**
     * @return Les habitants du pays
     */
	public List<Personne> getHabitants(){
		/*return villes.stream()
						.map(Ville::getHabitants)
						.flatMap(List::stream)
						.collect(toList());
		*/
		return this.getVilles().stream()
						.flatMap(v -> v.getHabitants().stream())
						.collect(toList());
	}

	/* Question 6 */
    /**
     * @return La ville la plus peuplé
     */
	public Optional<Ville> plusGrosseVille(){
		return villes.stream()
						.max(Comparator.comparing(Ville::getPopulation));
	}

	public Optional<Ville> plusGrandeVille(){
		return villes.stream()
						.reduce((v1,v2) -> v1.getPopulation() > v2.getPopulation() ? v1 : v2 );
	}

	/* Question 7 */
    /**
     * @return Moyenne d'age des habitants
     */
	public OptionalDouble moyenneAge(){
		return villes.stream()
						.flatMap(v -> v.getHabitants().stream())
						.mapToInt(Personne::getAge)
						.average();
	}

	

	
}