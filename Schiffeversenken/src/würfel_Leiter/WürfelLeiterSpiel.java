package würfel_Leiter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WürfelLeiterSpiel {
	private Spieler sp1;
	private Spieler sp2;
	private Würfel wuerfel[];
	private Datenbank daten= new Datenbank();
	private int zaeler;
	
	private Scanner sc = new Scanner(System.in);

	public WürfelLeiterSpiel() {
		// TODO Auto-generated constructor stub
		wuerfel = new Würfel[3];
		daten.auslesen();
		zaeler = 1;
	}
	public void anmeldenSpieler(){
		
		System.out.println("Anmelden:   \n1 zum Registrien.\n2 zum Anmelden.");
		
		if(sc.next().equals("1")) {
			registrierenSpieler();
		}else {
			System.out.println("Name:");
			String n = sc.next();
			System.out.println("Passwort:");
			String p = sc.next();
			if(daten.login(n, p) == true) {
				if(zaeler == 1){
					sp1 = new Spieler(daten.getName(),wuerfel);
					sp1.setAnzGewonneneSpiele(daten.getGewonnen());
					zaeler++;
				}else{
					sp2 = new Spieler(daten.getName(),wuerfel);
					sp1.setAnzGewonneneSpiele(daten.getGewonnen());
				}
				System.out.println("Erfolgreich");
			}else {
				System.out.println("Fehler!!");
				anmeldenSpieler();
			}
		}
	}
	public void registrierenSpieler(){
		daten.registrieren();
		anmeldenSpieler();
	}
	public void spielen(){
		
		
		int test = 0;
		
		while (test == 0) {
			
			if(sp1.wuerfeln() == true){
				System.out.println(sp1.getName() + " hat Gewonnen!!");
				test= 1;
				sp1.setAnzGewonneneSpiele(sp1.getAnzGewonneneSpiele()+1);
				daten.gewonneneintragen(sp1.getName(), sp1);
			}
			if(sp2.wuerfeln() == true){
				System.out.println(sp2.getName() + " hat Gewonnen!!");
				test = 1;
				sp2.setAnzGewonneneSpiele(sp1.getAnzGewonneneSpiele()+1);
				daten.gewonneneintragen(sp2.getName(), sp2);
			}
		}
		
	}
	private void ermittleGewinner(){
		
	}
}
