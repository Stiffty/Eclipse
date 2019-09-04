package MessungBetriebsystem;

public class HDD {

	private String hersteller;
	private double kapazitaet;
	private char partition;
	
	public HDD(String h,double k) {
		// TODO Auto-generated constructor stub
		this.hersteller = h;
		this.kapazitaet = k;
	}

	public HDD(String hersteller, double kapazitaet, char partition) {
		this.hersteller = hersteller;
		this.kapazitaet = kapazitaet;
		this.partition = partition;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public double getKapazitaet() {
		return kapazitaet;
	}

	public void setKapazitaet(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	public char getPartition() {
		return partition;
	}

	public void setPartition(char partition) {
		this.partition = partition;
	}

	

}
