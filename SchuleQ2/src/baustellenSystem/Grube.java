package baustellenSystem;

public class Grube {

	private int  sollGroesse;
	private int aktuelleGroesse;
	
	public Grube(int sollGroesse) {
		super();
		this.sollGroesse = sollGroesse;
		aktuelleGroesse = sollGroesse;
	}
	
	public  void ausheben(int menge){
		//synchronized (this) {
		aktuelleGroesse-=menge;
		//System.out.printf("Es wurden %s ausgehoben. Die Grube ist noch %s m^2 groﬂ.%n%n",menge,aktuelleGroesse);
	}
	//}

	public int getSollGroesse() {
		return sollGroesse;
	}

	public void setSollGroesse(int sollGroesse) {
		this.sollGroesse = sollGroesse;
	}

	public int getAktuelleGroesse() {
		return aktuelleGroesse;
	}

	public void setAktuelleGroesse(int aktuelleGroesse) {
		this.aktuelleGroesse = aktuelleGroesse;
	}
	
	
}
