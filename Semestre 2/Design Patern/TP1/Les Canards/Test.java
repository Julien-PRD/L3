/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 09:21:44 CET 2021
*
*/
public class Test {

	public static void main(String args[]){
		Simulateur s = new Simulateur();
		FabriqueAbstraite fabriqueDeCanards = new FabriqueDeCanards();
		FabriqueAbstraite fabriqueDeCanardsComptage = new FabriqueDeComptage();
		
		s.simuler4(fabriqueDeCanards);
	}
	
}