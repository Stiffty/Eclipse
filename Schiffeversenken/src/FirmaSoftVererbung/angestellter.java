package FirmaSoftVererbung;

public class angestellter extends person{

	private boolean istAuserdienst;
	private int kundegungsfrist;
	public angestellter(String name, String gebdatum,int mgehalt,boolean ia, int kf) {
		// TODO Auto-generated constructor stub
		super(name, gebdatum, mgehalt);
		this.istAuserdienst = ia;
		this.kundegungsfrist = kf;
	}

}
