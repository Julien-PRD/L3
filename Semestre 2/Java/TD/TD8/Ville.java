/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Tue Mar 09 13:31:40 CET 2021
*
*/

import java.util.*;
import static java.util.stream.Collectors.*;

public class Ville {
    private String nom;
    private List<Personne> habitants;
    
    public Ville(String nom) {
        super();
        this.nom = nom;
        habitants = new ArrayList<Personne>();
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * @return the habitants
     */
    public List<Personne> getHabitants() {
        return habitants;
    }

    
	public int getPopulation(){
        return habitants.size();
    }

    public void ajouteHabitant(Personne p){
        this.habitants.add(p);
    }

	/* Question 7 */
    /**
     * @return Moyenne d'age des habitants
     */
    public OptionalDouble moyenneAge(){
    	return this.getHabitants().stream()
    					.mapToInt(Personne::getAge)
    					.average();
    }

}