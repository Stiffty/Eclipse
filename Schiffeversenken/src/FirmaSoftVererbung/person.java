package FirmaSoftVererbung;

public class person {

	private String name;
	private String gebdatum;
	private int mgehalt;
	private static int zaehler = 1000;
	private int personalnummer;

	public person(String name, String gebdatum, int monatsgehalt) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gebdatum = gebdatum;
		this.mgehalt = monatsgehalt;
	}

	public int berechneJahresgehalt() {

		return mgehalt*12;
	}

	public String gruessen() {

		return "Guten Tag";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGebdatum() {
		return gebdatum;
	}

	public void setGebdatum(String gebdatum) {
		this.gebdatum = gebdatum;
	}

	public int getMgehalt() {
		return mgehalt;
	}

	public void setMgehalt(int mgehalt) {
		this.mgehalt = mgehalt;
	}

	public static int getZaehler() {
		return zaehler;
	}

	public static void setZaehler(int zaehler) {
		person.zaehler = zaehler;
	}

	public int getPersonalnummer() {
		return personalnummer;
	}

	public void setPersonalnummer(int personalnummer) {
		this.personalnummer = personalnummer;
	}

}
