package würfel_Leiter;

public class Leiterkarte {

	private boolean lK[] = new boolean[6];

	public Leiterkarte() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < lK.length; i++) {
			lK[i] = false;
		}
	}

	public int eintragen(Würfel wurfel[]) {

		return 1;
	}

	public int ermittleErreichteStufe() {

		return 1;
	}

	public boolean getlKW(int i) {
		return lK[i];
	}

	public boolean[] getlK() {
		return lK;
	}

	public void setlK(boolean lK, int i) {
		this.lK[i] = lK;
	}
}
