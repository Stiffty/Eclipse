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
	
	private Scanner sc = new Scanner(System.in);

	public WürfelLeiterSpiel() {
		// TODO Auto-generated constructor stub
		wuerfel = new Würfel[3];
		daten.auslesen();
		
	}
	public void anmeldenSpieler(){
		
		System.out.println("Anmelden:   \n1 zum Registrien.");
		
		if(sc.next().equals("1")) {
			registrierenSpieler();
		}else {
			System.out.println("Name:");
			String n = sc.next();
			System.out.println("Passwort:");
			String p = sc.next();
			if(daten.login(n, p) == true) {
				System.out.println("Erfolgreich");
			}else {
				System.out.println("Fehler!!");
			}
		}
	}
	public void registrierenSpieler(){
		daten.registrieren();
		
		
		
	}
	public void spielen(){
		sp1 = new Spieler();
		sp2 = new Spieler();
		
		int test = 0;
		
		while (test == 0) {
			
			if(sp1.wuerfeln() == true){
				System.out.println(sp1.getName() + "hat Gewonnen!!");
				test= 1;
			}
			if(sp1.wuerfeln() == true){
				System.out.println(sp2.getName() + "hat Gewonnen!!");
				test = 1;
			}
		}
		
	}
	private void ermittleGewinner(){
		
	}
}
