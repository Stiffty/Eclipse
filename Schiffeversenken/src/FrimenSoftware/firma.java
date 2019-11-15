package FrimenSoftware;

import java.util.ArrayList;
import java.util.List;

public class firma {

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
}
