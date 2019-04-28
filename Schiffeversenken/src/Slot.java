import java.util.Random;

public class Slot {

	public Slot() {
		// TODO Auto-generated constructor stub
		int zahl;
		int konto = 400;
		int gewinn = 0;
		int allesweg = 0; 
		int gewinner = 0;
		int höchstgewinn = 0;
		int hauptgewinn = 0;
		int ziehungen = 0;
		int g100 = 0;
		int g50 = 0;
		int g10 = 0;
		int g5 = 0;
		int g1 = 0;
		Random rand = new Random();
		for (int j = 0; j < 50000; j++) {
			
		
		konto = 50;
		for (int i = 0; i <1000; i++) {
			
		konto-=2;
		gewinn+=2;
		
		zahl = rand.nextInt(650)+1 ;
		ziehungen++;
		
		if (zahl == 1 ) {
			System.out.println("Hauptgewinn");
			konto+=500;
			gewinn-=500;
			hauptgewinn++;
		}else if (zahl == 2||zahl == 3) {
			System.out.println("100€");
			konto+=100;
			gewinn-=100;
			g100++;
		}else if (zahl >= 4&&zahl <= 7) {
			System.out.println("50€");
			konto+=50;
			gewinn-=50;
			g50++;
		}else if (zahl >= 8&&zahl <= 15) {
			System.out.println("10€");
			konto+=10;
			gewinn-=10;
			g10++;
		}else if (zahl >= 16&&zahl <= 31) {
			System.out.println("5€");
			konto+=5;
			gewinn-=5;
			g5++;
		}else if (zahl>183&&zahl<367) {
			System.out.println("1€");
			konto+=1;
			gewinn-=1;
			g1++;
		}else {
			System.out.println("Niete");
		}
		if (konto <= 0) {
			i = 1000;
			allesweg++;
		}
		}
		if (konto>100) {
			gewinner++;
		}
		if (konto>höchstgewinn) {
			höchstgewinn = konto;
		}
		System.out.println("Konto: " + konto + "€");
		}
		System.out.println("500€ " + hauptgewinn + "\n100€ " + g100+ "\n50€ " + g50
				+ "\n10€ " + g10+ "\n5€ " + g5 + "\n1€ "+g1 + "\n"+
				"Ziehungen: " + ziehungen + "\n" +
				"HöchstGewinn: " + höchstgewinn + "\n" +
				"Gewinner: " + gewinner + "\n"+
				"alles WEG: " + allesweg + "\n"+
				"Gewinn: " + gewinn + "€");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Slot();
	}

}
