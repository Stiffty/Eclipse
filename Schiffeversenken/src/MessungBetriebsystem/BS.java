package MessungBetriebsystem;

import java.util.Arrays;
import java.util.Random;

public class BS {

	private String name;
	private int version;
	private int patch;
	private int anzahlProzesse;
	private Prozess[] prozess;
	private HDD[] hdd;

	public BS(String n, int v, int p, Prozess pro, String h, double k) {
		// TODO Auto-generated constructor stub

		this.name = n;
		this.version = v;
		this.patch = p;
		
		prozess = new Prozess[15];
		for (int i = 0; i < this.prozess.length; i++) {
			prozess[i] = null;
		}
		hdd = new HDD[20];
		for (int i = 0; i < this.hdd.length; i++) {
			hdd[i] = null;
		}
	    HDD hdd1 = new HDD(h, k);
		hinzufuegen(hdd1);

	}

	public int hinzufuegen(Prozess pro) {

		if (sucheLeerstelleProzess(prozess) == (Integer) null) {
			return 0;
		} else {
			prozess[sucheLeerstelleProzess(prozess)] = pro;
			return 1;
		}
	}

	public int entfernen() {

		if (prozess[1] == null) {
			return 0;
		}
		try {
			for (int i = 0; i < prozess.length; i++) {
				prozess[i] = prozess[i + 1];

			}
		} catch (Exception e) {
			// TODO: handle exception
			prozess[14] = null;

		}
		return 1;

	}

	public boolean hinzufuegen(HDD hdd) {

		if (sucheLeerstelleHDD(this.hdd) == (Integer) null) {
			return false;
		} else {
			this.hdd[sucheLeerstelleHDD(this.hdd)] = hdd;
			return true;
		}

	}

	public boolean entferneHDD(char p) {
		for (int i = 0; i < hdd.length; i++) {
			if (this.hdd[i].getPartition() == p) {
				this.hdd[i] = null;
				return true;
			}
		}
		return false;
	}

	public boolean tauscheHDD(char partition, HDD hdd) {
		for (int i = 0; i < this.hdd.length; i++) {
			if (this.hdd[i].getPartition() == partition) {
				this.hdd[i] = hdd;
				return true;
			}
		}
		return false;
	}

	public double brerechneGesamtkazitaet() {

		double ges = 0;
		for (int i = 0; i < hdd.length; i++) {
			if(hdd[i] != null){
				ges+=hdd[i].getKapazitaet();
			}
		}
		return ges;
	}

	public String toStringHDDs() {

		String aus = "HDDs derPCs:"+System.lineSeparator();
		for (int i = 0; i < hdd.length; i++) {
			aus += i+1 +
					". Partition" +
					hdd[i].getPartition()+
					": "+
					"Hersteller: " +
					hdd[i].getHersteller() +
					", Kapazitaet : " +
					hdd[i].getKapazitaet() +
					" GB "+System.lineSeparator();
		}
		return aus;
	}

	public String toStringProzesse() {

		String aus = "Prozesse des PC:"+ System.lineSeparator();
		for (int i = 0; i < prozess.length; i++) {
			aus+= "1. "+
					prozess[i].getName()+", "+
					prozess[i].isLaufend()+", "+
					prozess[i].isBereit()+", Prio "+
					prozess[i].getPrio()+System.lineSeparator();
		}
		return aus;
	}

	@SuppressWarnings("null")
	private int sucheLeerstelleHDD(HDD[] hdd) {
		for (int i = 0; i < hdd.length; i++) {
			if (hdd[i] == null) {
				return i;
			}
		}
		return (Integer) null;
	}

	@SuppressWarnings("null")
	private int sucheLeerstelleProzess(Prozess[] prozess) {
		for (int i = 0; i < prozess.length; i++) {
			if (prozess[i] == null) {
				return i;
			}
		}
		return (Integer) null;
	}

	private boolean hddPartitionbezeichnungTest(HDD hdd) {
		int part = (int) hdd.getPartition();

		Random rd = new Random();

		if (part >= 68 && part <= 90) {
			return true;
		} else {
			boolean test = true;
			do {
				int rnd = 68 + rd.nextInt(22);
				hdd.setPartition((char) rnd);

				for (int i = 0; i < this.hdd.length; i++) {
					if (hdd.getPartition() != (char) rnd) {
						test = false;
					}
				}

			} while (test == true);
			return true;
		}
	}

	@Override
	public String toString() {
		return "BS [name=" + name + ", version=" + version + ", patch=" + patch + ", anzahlProzesse=" + anzahlProzesse
				+ ", prozess=" + Arrays.toString(prozess) + ", hdd=" + Arrays.toString(hdd) + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getPatch() {
		return patch;
	}

	public void setPatch(int patch) {
		this.patch = patch;
	}

	public int getAnzahlProzesse() {
		return anzahlProzesse;
	}

	public void setAnzahlProzesse(int anzahlProzesse) {
		this.anzahlProzesse = anzahlProzesse;
	}

	public Prozess[] getProzess() {
		return prozess;
	}

	public void setProzess(Prozess[] prozess) {
		this.prozess = prozess;
	}

	public HDD[] getHdd() {
		return hdd;
	}

	public void setHdd(HDD[] hdd) {
		this.hdd = hdd;
	}
}
