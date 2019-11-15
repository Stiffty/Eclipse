package FrimenSoftware;

public class produkt {

	private String produktname;
	private double preis;
	private int anzahl;

	public produkt(String produktname, double preis) {
		// TODO Auto-generated constructor stub
		this.produktname = produktname;
		this.preis = preis;
	}

	public String getProduktname() {
		return produktname;
	}

	public void setProduktname(String produktname) {
		this.produktname = produktname;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

}
