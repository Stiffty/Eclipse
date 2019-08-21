package Regal;

import java.util.ArrayList;
import java.util.List;

public class RegalMain {
	
	private int hoehe = 240;
	private int breite = 120;
	private int tiefe = 40;
	private int BuecherGesamt = 0;
	private int fachnummer = 0;
	private List<Fach> Faecher = new ArrayList<Fach>();
	

	public RegalMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean Facherstellen(int etage,int hoehe,int breite,int tiefe,String thema){
		
		Faecher.add(new Fach());
		Faecher.get(fachnummer).setEtage(etage);
		Faecher.get(fachnummer).setBreite(breite);
		Faecher.get(fachnummer).setHoehe(hoehe);
		Faecher.get(fachnummer).setTiefe(tiefe);
		Faecher.get(fachnummer).setThema(thema);
	    Faecher.get(fachnummer).setFachnummer(fachnummer);
		
		if(HUBtest(etage) == false) {
			Faecher.remove(fachnummer);
			
			System.out.println("Unzulässiges Fach");
			return false;
		}else {
			fachnummer++;
			return true;
		}
		
		
	}
	private boolean HUBtest(int etage) {
		int breite = 0;
		int höhe = 0;
		for (int i = 0; i < Faecher.size(); i++) {
			
			höhe=+Faecher.get(i).getHoehe();
			
			if(Faecher.get(i).getEtage() == etage) {
				breite=+Faecher.get(i).getBreite();
			}
		}
		return breite<=this.breite&& höhe<=this.hoehe ? true : false;
	}

	public List<Fach> getFaecher() {
		return Faecher;
	}

	public void setFaecher(List<Fach> faecher) {
		Faecher = faecher;
	}

}
