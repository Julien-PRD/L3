/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 29 10:00:41 CET 2021
*
*/
import java.util.*;

public class Borne extends Glarks{

	private Direction direction;

	/**
	 * Même constructeur mais on ajoute une direction
	 */
	public Borne(int energie, CaseLibre caseCourante, Direction direction){
		super(energie, caseCourante);
		this.direction = direction;
	}

	/**
	 * Un glark borne est borne, donc on change cette méthode pour qu'elle return true
	 * @return true
	 */
	public boolean estBorne(){
		return true;
	}

	/**
	 * Ce message est envoyé par la case destination quand un glark se déplace, le glark
	 * receveur est celui qui mange et le paramètre est le repas.
	 */
	public void devoreGlark(Glarks repas){
		if(repas.estBorne()==false){
			this.setEnergie(repas.getEnergie());
			repas.meurs();
		}
	}

	/**
	 * Retourne la case où va se diriger le Glark
	 * @return Une CaseLibre
	 */
	public CaseLibre trouveDestination(){
		caseCourante = voisineDansDir();
	}
	
}