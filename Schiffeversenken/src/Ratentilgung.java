import java.util.*;
public class Ratentilgung {

	public Ratentilgung() {
		// TODO Auto-generated constructor stub
		double restSB;
		double restSE = 0;
		double zinsen;
		double tilgung = 0;
		double annuität;
		double jahre;
		double test = 1; 
		double gesamt[] = new double[4];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie ihre Darlenssumme ein.");
		restSB = sc.nextDouble();
		System.out.println("Bitte geben Sie den Zinssatz ein.");
		zinsen = sc.nextDouble();
		System.out.println("Bitte geben Sie sie Anzahl der Jahre ein");
		jahre = sc.nextDouble();
		
		for (int i = 0; i < jahre; i++) {
			if (test == 1) {
				System.out.println("Jahr|Virtel Jahr|Restschuld Beginn| Zinsen | Tilgung | Annuität | Restschuld Ende ");
				test = 0;
				}
			System.out.print((i+1) + " | ");
			for (int j = 0; j < 4; j++) {
				restSB = restSB - tilgung;
				zinsen = zinsen(restSB, i, j );
				gesamt [0] = gesamt [0] + zinsen;
				tilgung = tilgung(jahre, restSB);
				gesamt [1] = gesamt [1] + tilgung;
				annuität = annuität(zinsen, tilgung );
				gesamt [2] = gesamt [2] + annuität;
				restSE = restSB - tilgung;
				
				ausgabe(j, restSB, zinsen, tilgung, annuität, restSE);
			}
			
		}
		gesamt[3] = gesamt[3] + restSE;
		System.out.println("***********************************************");
		System.out.println("Gesamt |        |         | " + gesamt[0] + " | " + gesamt[1] + " | " + gesamt[2]+ " | " + gesamt[3]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ratentilgung();
	}

public void ausgabe(double j, double restSB, double zinsen, double tilgung, double annuität, double restSE) {
	j++;
	System.out.println( j + " | " + restSB + " | " + zinsen + " | " + tilgung + " | " + annuität + " | " + restSE);
}
public double zinsen(double restSB, double i, double j) {
	double zinsen;
	i++;
	j++;
	zinsen = restSB*(i/j);
	return zinsen;
}
public double tilgung (double jahre, double restSB) {
	double tilgung;
	tilgung = restSB/(jahre*4);
	return tilgung;
}
public double annuität(double zinsen, double tilgung) {
	double annuität;
	annuität = zinsen + tilgung; 
	return annuität;
}

}