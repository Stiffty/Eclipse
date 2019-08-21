package Regal;

import java.util.ArrayList;
import java.util.List;

public class RegalMain {
	
	private int hoehe = 240;
	private int breite = 120;
	private int tiefe = 40;
	private int BuecherGesamt = 0;
	private List<Fach> Faecher = new ArrayList<Fach>();
	

	public RegalMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void Facherstellen(Fach fachname){
		Faecher.add(new Fach());
		Faecher.get(0).addBuch(buchName);
	}

}
