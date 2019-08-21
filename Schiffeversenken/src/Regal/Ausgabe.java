package Regal;

import java.util.*;

public class Ausgabe {

	static boolean exit = false;
	
	private static Scanner sc = new Scanner(System.in);
	private static RegalMain regal = new RegalMain();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			System.out.println("1 für Facherstellen, 2 für Buch erstellen, 3 um verzeichnis zu sehen, 4 für exit");
			int eingabe = sc.nextInt();
			switch (eingabe) {
			case 1:
				FErstellen();
				break;

				case 2:
					System.out.println("In welchem Fach erstellen?(Fachnummer!!)");
					Fachausgabe();
					eingabe = sc.nextInt();
					Bucherstellen(eingabe);
					break;
				case 3:
					display();
					break;
			    case 4:
					exit = true;
					break;
			default:
				break;
			}
		}while(exit == false);
		
	}

	public static void FErstellen() {
		int etage;
		int breite;
		int hoehe;
		String thema;
		do{
			System.out.print("Etage: ");
			etage = sc.nextInt();
			System.out.print("Breite: ");
			breite = sc.nextInt();
			System.out.print("Höhe: ");
			hoehe = sc.nextInt();
			System.out.print("Thema: ");
			thema = sc.next();
			}while(regal.Facherstellen(etage,breite,hoehe,0,thema) == false);
	}
	
	public static void Bucherstellen(int etage) {
		
		int hoehe;
		int breite;
		double preis;
		String name;
		String isbn;
		do {
			System.out.print("Breite: ");
			breite = sc.nextInt();
			System.out.print("Höhe: ");
			hoehe = sc.nextInt();
			System.out.print("Preis: ");
			preis = sc.nextDouble();
			System.out.print("Name: ");
			name = sc.next();
			System.out.print("ISBN (xxx-xxx): ");
			isbn = sc.next();
			sc.next();
		}while(regal.getFaecher().get(etage).addBuch(hoehe, breite, preis, name, isbn)== false);
		
	}
	
	public static void display () {
		for (int i = 0; i <regal.getFaecher().size() ; i++) {
			
			System.out.println(regal.getFaecher().get(i).getThema());
			
			for (int j = 0; j < regal.getFaecher().get(i).getBuecher().size(); j++) {
				System.out.print("   "+regal.getFaecher().get(i).getBuecher().get(j).getName()+ " ");
				System.out.println(regal.getFaecher().get(i).getBuecher().get(j).getPreis()+" €");
			}
		}
	}
	
	public static void Fachausgabe() {
		for (int i = 0; i < regal.getFaecher().size(); i++) {
			
			System.out.println("Thema: "+regal.getFaecher().get(i).getThema());
			System.out.println("Fachnummer: " + regal.getFaecher().get(i).getFachnummer());
			System.out.println("Etage: " + regal.getFaecher().get(i).getEtage());
			System.out.println("Höhe Breite: " + regal.getFaecher().get(i).getHoehe() + "x" +regal.getFaecher().get(i).getBreite());
			System.out.println();
		}
	}
}
