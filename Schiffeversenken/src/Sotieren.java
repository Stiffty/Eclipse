import java.util.*;

public class Sotieren {

	public Sotieren() {
		// TODO Auto-generated constructor stub
		int[] Feld = new int[1000000];
		int test = 0;
		int test1 = 0;

		Feld = f�llung(Feld);

		System.out.println("Davor");
		for (int i = 0; i < Feld.length; i++) {
			System.out.print(Feld[i] + " ");
			test++; 
		}
		System.out.println("");

		Feld = sortieren(Feld);

		System.out.println("Danach");
		for (int i = 0; i < Feld.length; i++) {
			System.out.print(Feld[i] + " ");
			test1++;
		}
		System.out.println("");
		System.out.println(test + " " + test1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sotieren();
	}

	public int[] f�llung(int[] Feld) {
		Random rand = new Random();
		for (int i = 0; i < Feld.length; i++) {
			Feld[i] = rand.nextInt(50);
		}
		return Feld;

	}

	public int[] sortieren(int[] Feld) {
		int a;
		int b;
		for (int j = 0; j < Feld.length; j++) {

			for (int i = 0; i < Feld.length; i++) {
				if (i == 0) {
					if (Feld[i] > Feld[i + 1]) {
						a = Feld[i];
						b = Feld[i + 1];

						Feld[i] = b;
						Feld[i + 1] = a;

					}
				} else if (i == (Feld.length - 1)) {
					if (Feld[i] < Feld[i - 1]) {
						a = Feld[i];
						b = Feld[i - 1];

						Feld[i] = b;
						Feld[i - 1] = a;
					}
				} else {
					if (Feld[i] > Feld[i + 1]) {
						a = Feld[i];
						b = Feld[i + 1];

						Feld[i] = b;
						Feld[i + 1] = a;

					}
					if (Feld[i] < Feld[i - 1]) {
						a = Feld[i];
						b = Feld[i - 1];

						Feld[i] = b;
						Feld[i - 1] = a;
					}
				}
			}
			
		}
		return Feld;
	}


}
