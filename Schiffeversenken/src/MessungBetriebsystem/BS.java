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

		prozess = new Prozess[9];
		for (int i = 0; i < this.prozess.length; i++) {
			prozess[i] = null;
		}
		hinzufuegen(pro);
		hdd = new HDD[9];
		for (int i = 0; i < this.hdd.length; i++) {
			hdd[i] = null;
		}
		
		hinzufuegen(new HDD(h, k));

	}

	public int hinzufuegen(Prozess pro) {

		if (sucheLeerstelleProzess(prozess) == -1) {
			return 0;
		} else {
			try {
				prozess[sucheLeerstelleProzess(prozess)] = pro;
			} catch (Exception e) {
				// TODO: handle exception
				return 0;
			}
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
			prozess[8] = null;

		}
		return 1;

	}

	public boolean hinzufuegen(HDD hdd) {

		if (sucheLeerstelleHDD(this.hdd) == -1) {
			return false;
		} else {
			try {
				this.hdd[sucheLeerstelleHDD(this.hdd)] = hdd;
				hddPartitionSetzen(this.hdd[sucheLeerstelleHDD(this.hdd)]);
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
			
			
			return true;
		}

	}

	public boolean entferneHDD(char p) {
		for (int i = 0; i < hdd.length; i++) {
			if (this.hdd[i].getPartition() == p) {
				try {
					for (int j = i; j < hdd.length; j++) {
						this.hdd[j] = this.hdd[j+1];
						hddPartitionSetzen(this.hdd[j]);
					}
				} catch (Exception e) {
					// TODO: handle exception
					return true;
				}
				
			}
		}
		return false;
	}

	public boolean tauscheHDD(char partition, HDD hdd) {
		for (int i = 0; i < this.hdd.length; i++) {
			if (this.hdd[i].getPartition() == partition) {
				hdd.setPartition(this.hdd[i].getPartition());
				this.hdd[i] = hdd;
				return true;
			}
		}
		return false;
	}

	public double brerechneGesamtkazitaet() {

		double ges = 0;
		for (int i = 0; i < hdd.length; i++) {
			if (hdd[i] != null) {
				ges += hdd[i].getKapazitaet();
			}
		}
		return  ges;
	}

	public String toStringHDDs(int i) {

		String aus = "";
		try {
			
				aus += i + 1 + ". Partition " + hdd[i].getPartition() + ": " + "Hersteller: " + hdd[i].getHersteller()
						+ ", Kapazitaet : " + hdd[i].getKapazitaet() + " GB " + System.lineSeparator();
			
		} catch (Exception e) {
			// TODO: handle exception
			return aus;
		}
		
		return aus;
	}

	public String toStringProzesse(int i) {

		
		String aus = "";
		try {
			
				aus += i+1 +". Name: "+ prozess[i].getName() + ", Laufend: " + prozess[i].isLaufend() + ", Bereit: " + prozess[i].isBereit()
						+ ", Prio: " + prozess[i].getPrio() + System.lineSeparator();
			
		} catch (Exception e) {
			// TODO: handle exception
			return aus;
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
		return -1;
	}

	@SuppressWarnings("null")
	private int sucheLeerstelleProzess(Prozess[] prozess) {
		for (int i = 0; i < prozess.length; i++) {
			if (prozess[i] == null) {
				return i;
			}
		}
		return -1;
	}

	private boolean hddPartitionbezeichnungTest(HDD hdd) {
		int part = (int) hdd.getPartition();

		Random rd = new Random();

		if (part >= 68 && part <= 90) {

			boolean test = true;
			do {

				hdd.setPartition((char) part);

				for (int i = 0; i < this.hdd.length; i++) {
					if (hdd.getPartition() != (char) part) {
						test = false;
					}
				}

			} while (test == true);
			return true;
		} else {
			boolean test = true;
			
			do {
				part++;
				hdd.setPartition((char) part);

				for (int i = 0; i < this.hdd.length; i++) {
					if (hdd.getPartition() != (char) part) {
						test = false;
					}
				}

			} while (test == true);
			return true;
		}
	}

	private void hddPartitionSetzen(HDD hdd ) {
		int i = 67;
		for (int j = 0; j < this.hdd.length; j++) {
			if(this.hdd[j+1] == null&&this.hdd[j] != null ) {
				this.hdd[j].setPartition((char)i);
				break;
		}else {
			i++;
		}
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
