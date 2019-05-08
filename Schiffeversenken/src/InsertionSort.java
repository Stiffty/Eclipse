import java.util.*;

public class InsertionSort {
	private int länge = 12;
	private int[] zahlen = new int[länge];
	private int[] Test = new int[länge];
	private int test = 0;

	public InsertionSort() {
		// TODO Auto-generated constructor stub

		Random rand = new Random();

		for (int i = 0; i < zahlen.length; i++) {
			test = 0;
			while (test == 0) {
				zahlen[i] = rand.nextInt(länge);
				Test[zahlen[i]]++;
				test = 1;
				if (Test[zahlen[i]] > 1) {
					test = 0;
				}
			}
		}

		System.out.println("Davor");
		for (int i = 0; i < zahlen.length; i++) {
			if (i < 100) {
				System.out.print(zahlen[i] + " ");

			}
			test++;
		}
		System.out.println("");

		int second = 0;
		int kleinster = 0;
		int vergleiche = 0;
		int tausch = 0;
		for (int i = 0; i < zahlen.length; i++) {

			for (int j = 0 + kleinster; j < zahlen.length; j++) {
				vergleiche++;
				ausgabe();

//				//test
				try {
					if (zahlen[j] > zahlen[j+1]) {
						second = zahlen[j];
						zahlen[j] = zahlen[j + 1];
						zahlen[j + 1] = second;
					}
//				if(zahlen[j] >zahlen[j+1]) {
//					second = zahlen[j];
//					zahlen[j] = zahlen[j+1];
//					zahlen[j+1] = second;
//				}
//				if(zahlen[j] <zahlen[j-1]) {
//					second = zahlen[j];
//					zahlen[j] = zahlen[j-1];
//					zahlen[j-1] = second;
//				}
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					// TODO: handle exception
				}

				if (zahlen[j] <= kleinster) {
					second = zahlen[j];
					zahlen[j] = zahlen[i];
					zahlen[i] = second;

					kleinster++;
					tausch++;
					j = zahlen.length;

				}
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("Vergleiche: " + vergleiche);
		System.out.println("Tausch: " + tausch);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InsertionSort();
	}

	private void ausgabe() {
		// System.out.println("Danach");
		System.out.println("");
		for (int i = 0; i < zahlen.length; i++) {
			if (i < 1000) {
				System.out.print(zahlen[i] + " ");

			}

		}

	}
}
