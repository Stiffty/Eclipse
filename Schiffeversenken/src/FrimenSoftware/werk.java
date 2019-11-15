package FrimenSoftware;

public class werk {

	private String bezeichnung;
	private double umsatz;
	private produkt Produkt;

	public werk(String bezeichnung, String nameProdukt, double preisP) {
		// TODO Auto-generated constructor stub
		this.bezeichnung = bezeichnung;
		this.Produkt = new produkt(nameProdukt, preisP);
	}

	public double berechneUmsatz() {

		return Double.valueOf(Produkt.getAnzahl()) * Produkt.getPreis();

	}

	public double einstellenProduktion() {
		double umsatz = berechneUmsatz();
		Produkt = null;
		return umsatz;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public double getUmsatz() {
		return umsatz;
	}

	public void setUmsatz(double umsatz) {
		this.umsatz = umsatz;
	}

	public produkt getProdukt() {
		return Produkt;
	}

	public void setProdukt(produkt produkt) {
		this.Produkt = produkt;
	}
}
