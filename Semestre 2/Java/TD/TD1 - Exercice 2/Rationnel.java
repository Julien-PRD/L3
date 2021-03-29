/**
* @author LeNomDeLEtudiant
* @version 0.1 : Date : Mon Jan 11 20:56:45 CET 2021
*
*/
public class Rationnel {

	private int p;
	private int q;

	//Constructeur
	public Rationnel(int p1, int q1){
		p = p1;
		q = q1;
	}

	public String toString(){
		String res = new String();
		res = "("+p+"/"+q+")";
		return res;
	}

	//Renvoie la valeur du numérateur du rationnel
	public int num(){
		int res = this.p;
		return res;
	}

	//Renvoie la valeur du dénominateur du rationnel
	public int den(){
		int res = this.q;
		return res;
	}

	//Renvoie le double le plus proche du rationnel représenté par l'objet
	public double toDouble(){
		double res, pdouble = this.p, qdouble = this.q;
		res = pdouble / qdouble;
		return res;
	}

	//Renvoie un nouvel object Rationnel somme du rationnel sur lequel s'applique la méthode
	//	et du rationnel r (this+r)
	public Rationnel somme(Rationnel r){
		int resP,resQ;
		resP = this.p * r.q + r.p * this.q;
		resQ = this.q * r.q;
		Rationnel res = new Rationnel(resP,resQ);
		return res;
	}

	//Renvoie un nouvel object Rationnel somme du rationnel sur lequel s'applique la méthode
	//	et du rationnel r (this-r)
	public Rationnel difference(Rationnel r){
		int resP,resQ;
		resP = this.p * r.q - r.p * this.q;
		resQ = this.q * r.q;
		Rationnel res = new Rationnel(resP,resQ);
		return res;
	}

	//Renvoie un nouvel object Rationnel somme du rationnel sur lequel s'applique la méthode
	//	et du rationnel r (this*r)
	public Rationnel produit(Rationnel r){
		int resP,resQ;
		resP = this.p * r.p;
		resQ = this.q * r.q;
		Rationnel res = new Rationnel(resP,resQ);
		return res;
	}

	//Renvoie un nouvel object Rationnel somme du rationnel sur lequel s'applique la méthode
	//	et du rationnel r (this*r)
	public Rationnel quotient(Rationnel r){
		int resP,resQ;
		resP = this.p * r.q;
		resQ = this.q * r.p;
		Rationnel res = new Rationnel(resP,resQ);
		return res;
	}

	//Renvoie un entier :
	//	< 0 si le rationnel sur lequel s'applique la méthode est plus petit que r
	//	= 0 s'ils sont égaux
	//	> 0 si r est plus petit
	public int compareTo(Rationnel r){
		if(this.toDouble() > r.toDouble()){
			return 1;
		}else if(this.toDouble() < r.toDouble()){
			return -1;
		}else{
			return 0;
		}
	}
	
}
