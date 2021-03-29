/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Fri Jan 22 15:31:58 CET 2021
*
*/
public class TestCalc {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
	
		UniteCentrale uc=new UniteCentrale();
		Ecran ecr=uc.getEcran();
		ToucheNumerique t1=new ToucheNumerique("1",ecr);
		ToucheNumerique t2=new ToucheNumerique("2",ecr);
		ToucheNumerique t3=new ToucheNumerique("3",ecr);
		ToucheNumerique t4=new ToucheNumerique("4",ecr);
		ToucheNumerique t5=new ToucheNumerique("5",ecr);
		ToucheNumerique t6=new ToucheNumerique("6",ecr);
		ToucheNumerique t7=new ToucheNumerique("7",ecr);
		ToucheNumerique t8=new ToucheNumerique("8",ecr);
		ToucheNumerique t9=new ToucheNumerique("9",ecr);
		ToucheNumerique t0=new ToucheNumerique("0",ecr);
		ToucheFonctionSpeciale tfac = new ToucheFonctionSpeciale("F",uc,"init");
		ToucheFonctionBinaire tPlus = new ToucheFonctionBinaire("+", uc, "plus");
		ToucheFonctionBinaire tMult = new ToucheFonctionBinaire("*", uc, "multi");
		ToucheFonctionBinaire tDiv = new ToucheFonctionBinaire("/", uc, "divi");
		ToucheFonctionBinaire tMoins = new ToucheFonctionBinaire("-", uc, "moins");
		ToucheFonctionSpeciale tval = new ToucheFonctionSpeciale("E",uc, "validation");
		ToucheFonctionUnaire tFacto=new ToucheFonctionUnaire("F",uc, "facto");
		
		t3.activeToi();
		t5.activeToi();
		tval.activeToi();
		t3.activeToi();
		tPlus.activeToi();
		t4.activeToi();
		tval.activeToi();
		t1.activeToi();
		t0.activeToi();
		tMult.activeToi();
		t5.activeToi();
		tFacto.activeToi();
		tPlus.activeToi();
		tMoins.activeToi();
		
		System.out.println("Résultat du calcul = " + ecr.valeur());
		System.out.println("Fini");
	}
}