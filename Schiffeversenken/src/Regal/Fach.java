package Regal;

import java.util.ArrayList;

public class Fach {

	private int hoehe;
	private int breite;
	private int tiefe;
	private String thema;
	private int etage;
	private int stelleEtage;
	private ArrayList<String> inhalt = new ArrayList<>();
	
	public Fach() {
		// TODO Auto-generated constructor stub
	}

	public void sethoehe(int zahl){
		this.hoehe = zahl;
	}
	public void setbreite(int zahl){
		this.breite = zahl;
	}
	public void settiefe(int zahl){
		this.tiefe = zahl;
	}
	public void setetage(int zahl){
		this.etage = zahl;
	}
	public void setstelleEtage(int zahl){
		this.stelleEtage = zahl;
	}
	public void setthema(String thema){
		this.thema = thema;
	}
	
	public void addBuch(String buchName){
		inhalt.add(buchName);
	}
}
