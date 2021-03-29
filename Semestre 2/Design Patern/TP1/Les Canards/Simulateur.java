/**
* @author Julien PROUDY
* @version 0.1 : Date : Wed Mar 17 09:06:04 CET 2021
*
*/
public class Simulateur{

	/**
	 * Question 1
	 */
	public void simuler1(){
		Cancaneur colvert = new Colvert();
		Cancaneur mandarin = new Mandarin();
		Cancaneur canardEnPlastique = new CanardEnPlastique();
		Cancaneur appeau = new Appeau();
		Cancaneur oie = new AdapteurDOie(new Oie());
		System.out.println("Simulateur de Canards");
		simuler(colvert);
		simuler(mandarin);
		simuler(canardEnPlastique);
		simuler(appeau);
		simuler(oie);
	}

	/**
	 * Question 2
	 */
	public void simuler2(){
		Cancaneur colvert = new CompteurDeCancans(new Colvert());
		Cancaneur mandarin = new CompteurDeCancans(new Mandarin());
		Cancaneur canardEnPlastique = new CompteurDeCancans(new CanardEnPlastique());
		Cancaneur appeau = new CompteurDeCancans(new Appeau());
		Cancaneur oie = new AdapteurDOie(new Oie()) ;
		Cancaneur colvertBegue = new Begue(new CompteurDeCancans(new Colvert()));
		
		System.out.println("Simulateur de Canards");
		
		simuler(colvert);
		simuler(mandarin);
		simuler(canardEnPlastique);
		simuler(appeau);
		simuler(oie);
		simuler(colvertBegue);
		System.out.println("Nous avons compte " +
		CompteurDeCancans.getNbCancans() + " cancans") ;
	}

	/**
	 * Question 3
	 */
	public void simuler3(FabriqueAbstraite fabriqueDeCanardsComptage){
		
		Cancaneur colvert = fabriqueDeCanardsComptage.nouveauColvert();
		Cancaneur mandarin = fabriqueDeCanardsComptage.nouveauMandarin();
		Cancaneur canardEnPlastique = fabriqueDeCanardsComptage.nouveauCanardEnPlastique();
		Cancaneur appeau = fabriqueDeCanardsComptage.nouveauAppeau();
		Cancaneur oie = new AdapteurDOie(new Oie());

		System.out.println("Simulateur de Canards");

		simuler(colvert);
		simuler(mandarin);
		simuler(canardEnPlastique);
		simuler(appeau);
		simuler(oie);

		System.out.println("Nous avons compte " + CompteurDeCancans.getNbCancans() + " cancans") ;
		
	}

	/**
	 * Question 4
	 */
	public void simuler4(FabriqueAbstraite fabriqueDeCanards){
		
		Cancaneur colvert = fabriqueDeCanards.nouveauColvert();
		Cancaneur mandarin = fabriqueDeCanards.nouveauMandarin();
		Cancaneur canardEnPlastique = fabriqueDeCanards.nouveauCanardEnPlastique();
		Cancaneur appeau = fabriqueDeCanards.nouveauAppeau();
		Cancaneur oie = new AdapteurDOie(new Oie());

		Troupe troupeDeCanards = new Troupe();

		troupeDeCanards.add(colvert);
		troupeDeCanards.add(mandarin);
		troupeDeCanards.add(canardEnPlastique);
		troupeDeCanards.add(appeau);
		troupeDeCanards.add(oie);

		Cancaneur mandarin1 = fabriqueDeCanards.nouveauMandarin();
		Cancaneur mandarin2 = fabriqueDeCanards.nouveauMandarin();
		Cancaneur mandarin3 = fabriqueDeCanards.nouveauMandarin();
		Cancaneur mandarin4 = fabriqueDeCanards.nouveauMandarin();
		Cancaneur mandarin5 = fabriqueDeCanards.nouveauMandarin();

		Troupe troupeMandarin = new Troupe();

		troupeMandarin.add(mandarin1);
		troupeMandarin.add(mandarin2);
		troupeMandarin.add(mandarin3);
		troupeMandarin.add(mandarin4);
		troupeMandarin.add(mandarin5);

		troupeDeCanards.add(troupeMandarin);

		System.out.println("TROUPE DE CANARDS");
		simuler(troupeDeCanards);
		System.out.println("TROUPE DE MANDARINS");
		simuler(troupeMandarin);
		
	}
	
	public void simuler(Cancaneur c){
		c.cancaner() ;
	}

}