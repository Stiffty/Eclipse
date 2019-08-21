package Regal;

import java.util.List;
import java.util.ArrayList;

public class Fach {

	private int hoehe;
	private int breite;
	private int tiefe;
	private String thema;
	private int etage;
	private int nummer = 0;
	private int fachnummer;
	private List<Buch> Buecher = new ArrayList<Buch>();
	
	public Fach() {
		// TODO Auto-generated constructor stub
	}


	public boolean addBuch(int hoehe,int breite,double preis,String name,String isbn) {
		Buecher.add(new Buch());
		Buecher.get(nummer).setHoehe(hoehe);
		Buecher.get(nummer).setBreite(breite);
		Buecher.get(nummer).setPreis(preis);
		Buecher.get(nummer).setName(name);
		Buecher.get(nummer).setISBN(isbn);
		Buecher.get(nummer).setbNummer(nummer);
		
		if(HUBtest(nummer) == false) {
			Buecher.remove(nummer);
			
			System.out.println("Buch ist zu Groß");
			return false;
		}else {
			nummer++;
			return true;
		}
	}
	
	private boolean HUBtest(int nummer) {
		int breite = 0;
		int höhe = 0;
		
		for (int i = 0; i < Buecher.size(); i++) {
			
		    breite=+Buecher.get(i).getBreite();
		}
		höhe=+Buecher.get(nummer).getHoehe();
		
		return breite<=this.breite&& höhe<=this.hoehe ? true : false;
	}
	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getTiefe() {
		return tiefe;
	}

	public void setTiefe(int tiefe) {
		this.tiefe = tiefe;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	


	public List<Buch> getBuecher() {
		return Buecher;
	}


	public void setBuecher(List<Buch> buecher) {
		Buecher = buecher;
	}


	public int getFachnummer() {
		return fachnummer;
	}


	public void setFachnummer(int fachnummer) {
		this.fachnummer = fachnummer;
	}
}
