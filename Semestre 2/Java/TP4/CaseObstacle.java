/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 09:55:01 CET 2021
*
*/
public class CaseObstacle extends Case{

	/**
	 * Même constructeur que la classe Case
	 */
	public CaseObstacle(int ligne, int colonne){
		super(ligne, colonne);
	}

	/**
	 * On rédefini la méthode obstacle, car une CaseObstacle est un "obstacle"
	 * @return true
	 */
	public boolean estObstacle(){
		return true;
	}
	
}