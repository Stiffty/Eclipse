package FrimenSoftware;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class firma implements Serializable {

	private String firmenname;
	private double gesamtUmsatz;
	private List<werk> werke;

	public firma(String firmenname) {
		// TODO Auto-generated constructor stub
		this.firmenname = firmenname;
		werke = new ArrayList<werk>();
	}

	public double brerechneGesamtUmsatz() {
		double umsatz = 0;

		for (int i = 0; i < werke.size(); i++) {
			umsatz = +werke.get(i).berechneUmsatz();
		}
		return umsatz;
	}

	public void steuereProduktion(int limit) {

		for (int i = 0; i < werke.size(); i++) {
			if (werke.get(i).berechneUmsatz() < limit) {
				werke.get(i).einstellenProduktion();
			}
		}
	}

	public String getFirmenname() {
		return firmenname;
	}

	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	public double getGesamtUmsatz() {
		return gesamtUmsatz;
	}

	public void setGesamtUmsatz(double gesamtUmsatz) {
		this.gesamtUmsatz = gesamtUmsatz;
	}

	public List<werk> getWerke() {
		return werke;
	}

	public void setWerke(List<werk> werke) {
		this.werke = werke;
	}
}
