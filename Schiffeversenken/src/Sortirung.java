import java.util.Random;

public class Sortirung {

	public Sortirung() {
		// TODO Auto-generated constructor stub
		int[] Feld = new int[100];

		int test = 0;
		int test1 = 0;

		Feld = füllung(Feld);

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
		new Sortirung();
	}

	public int[] füllung(int[] Feld) {
		int[] Test = new int[100];
		int test = 0;
		Random rand = new Random();

		for (int i = Feld.length / 2; i < Feld.length; i++) {
			test = 0;
			while (test == 0) {
				Feld[i] = rand.nextInt(50);
				Test[Feld[i]]++;
				test = 1;
				if (Test[Feld[i]] > 1) {
					test = 0;
				}
			}
		}
		return Feld;

	}

	public int[] sortieren(int[] Feld) {
		int max = 1;
		int a;
		int b;
		int c = 0;
		
		int test = 0;

		for (int i = (Feld.length / 2)-1; i < Feld.length; i++) {

			while (test == 0) {
				if (Feld[i] == max) {
					Feld[c] = Feld[i];
					c++;
					max++;
					test = 1;
				} else {
					test = 0;
					
				}
				
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
