package würfel_Leiter;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Datenbank {

	private Scanner sc = new Scanner (System.in);
	
	private List<String> daten = new LinkedList<String>();
	private String name;
	private int gewonnen;
	public Datenbank() {
		// TODO Auto-generated constructor stub
		
	}

	public void auslesen() {
		try {
			String line;
			FileReader fr = new FileReader("LoginDaten.txt");
			BufferedReader br = new BufferedReader(fr);
			
			 while (null != (line = br.readLine())) {
		           daten.add(line);
		          } 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void registrieren() {
		try {
			File daten = new File("LoginDaten.txt");
			FileWriter fw = new FileWriter(daten,true);
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader in = new BufferedReader(new FileReader("Logindaten.txt"));
	
			System.out.println("Bitte geben Sie Ihr Name an.");
			bw.write(sc.next()+ ":");
			System.out.println("Bitte geben sie Ihr Passwort an.");
			bw.write(sc.next()+ ":0");
			bw.newLine();
			bw.flush();

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String name, String pass) {
		auslesen();
		for (int i = 0; i < daten.size(); i++) {
			String[] split = daten.get(i).split(":");
			
			this.gewonnen = Integer.parseInt(split[2]);
			
			if(split[0].equals(name)) {
				if(split[1].equals(pass)) {
					this.name = split[0];
					return true;
				}
			}
		}
		return false;
	}
	public void gewonneneintragen(String name, Spieler sp){
		auslesen();
		for (int i = 0; i < daten.size(); i++) {
			String[] split = daten.get(i).split(":");
			
			this.gewonnen = Integer.parseInt(split[2]);
			
			if(split[0].equals(name)) {
				try {
					File daten = new File("LoginDaten.txt");
					FileWriter fw = new FileWriter(daten,true);
					BufferedWriter bw = new BufferedWriter(fw);
					BufferedReader in = new BufferedReader(new FileReader("Logindaten.txt"));
			
					
					bw.write(sc.next()+ ":" + sp.getAnzGewonneneSpiele());
					bw.newLine();
					bw.flush();

					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public int getGewonnen() {
		return gewonnen;
	}

	public void setGewonnen(int gewonnen) {
		this.gewonnen = gewonnen;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public List<String> getDaten() {
		return daten;
	}

	public void setDaten(List<String> daten) {
		this.daten = daten;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
