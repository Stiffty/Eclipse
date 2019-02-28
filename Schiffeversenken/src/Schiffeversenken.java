import java.util.*;

public class Schiffeversenken {
	public Schiffeversenken() {

		int p1[][] = new int[10][10];
		int p2[][] = new int[10][10];
		String tabelle[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		int schiff[] = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
		int hoch;
		int tief;
		boolean treffer = true;
		

		Random rand = new Random();

		for (int x = 0; x < p1.length; x++) {
			for (int y = 0; y < p1[0].length; y++) {
				p1[x][y] = 0;
				p2[x][y] = 0;
			}
		}
		for (int i = 0; i < schiff.length; i++) {
			hoch = rand.nextInt(10);
			tief = rand.nextInt(10);

			if (testefeld(p1, hoch, tief, schiff, i) == false) {
				hoch = rand.nextInt(10);
				tief = rand.nextInt(10);
				i = i - 1;

			} else {
				for (int a = 0; a < (schiff[i]); a++) {
					p1[(hoch + a)][(tief)] = 1;

				}

			}

		}

		for (int i = 0; i < schiff.length; i++) {
			hoch = rand.nextInt(10);
			tief = rand.nextInt(10);

			if (testefeld(p2, hoch, tief, schiff, i) == false) {
				hoch = rand.nextInt(10);
				tief = rand.nextInt(10);
				i = i - 1;

			} else {
				for (int a = 0; a < (schiff[i]); a++) {
					p2[(hoch + a)][(tief)] = 1;

				}

			}

		}
		// KIP1
		int x = 0;
		int y = 0;

		int counter = 0;
		while (testrunde(p1, p2) == true) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);
			counter = 0;
			treffer = true;
			//KIP1
			if(p1[x][y] == 3||p1[x][y] ==4) {
				treffer = false;
			}
			while (treffer == true) {
				if (schussp1(p1, x, y) == true) {
					p1[x][y] = 4;
					System.out.println("P1");
					ausgabe(p1, tabelle);
                    System.out.println("Treffer");
                    System.out.println("Schusskoordinate = " + x +" " + y );
					treffer = true;
					if (p1[(x + 1)][y] == 1) {
						counter++;
						x++;
					} else {
						x = x - counter;
						counter = 0;
						x--;
						
					}
				} else {
					p1[x][y] = 3;
					System.out.println("P1");
					ausgabe(p1, tabelle);
					System.out.println("Verfehlt");
					System.out.println("Schusskoordinate = " + x +" " + y );
					treffer = false;
				}
			}
			//KIP2
			while (treffer == false) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);
			counter = 0;
			treffer = true;
			if(p2[x][y] == 3||p2[x][y] ==4) {
				treffer = false;
			}
			}
			while (treffer == true) {
				if (schussp2(p2, x, y) == true) {
					p2[x][y] = 4;
					System.out.println("P2");
					ausgabe(p2, tabelle);
					System.out.println("Schusskoordinate = " + x +" " + y );
					System.out.println("Treffer");
					treffer = true;
					if (p2[(x + 1)][y] == 1) {
						counter++;
						x++;
					} else {
						x = x - counter;
						counter = 0;
						x--;
						
					}
				} else {
					p2[x][y] = 3;
					System.out.println("P2");
					ausgabe(p2, tabelle);
					System.out.println("Verfehlt");
					System.out.println("Schusskoordinate = " + x +" " + y );
					treffer = false;
				}
			}
		}
		/*
		 * int x = 0; int y = 0; int counter = 0; int test3 = 0; int test4 = 0;
		 * ausgabe(p1, tabelle); while (testrunde(p1, p2) == true) { // p1KI
		 * 
		 * System.out.println("P1KI"); ausgabe(p1, tabelle); treffer = true; x =
		 * rand.nextInt(10); y = rand.nextInt(10); counter = 0; test3 = 1; test4 = 0;
		 * while (treffer == true) {
		 * 
		 * if (schuss(p1, p2, x, y) == true) { p1[x][y] = 4; if (test == false &&
		 * treffer == true) { x++; counter++; test4 = 1; ausgabe(p1, tabelle); } else {
		 * if (test3 == 1) { x = x - counter; test3 = 0; } x--;
		 * 
		 * ausgabe(p1, tabelle); }
		 * 
		 * treffer = true; } else { if (test4 == 1 && treffer == true) { test = true; }
		 * else { test = false; } p1[x][y] = 3; treffer = false;
		 * 
		 * }
		 * 
		 * } }
		 */

	}

	public static void main(String[] args) {
		new Schiffeversenken();
	}

	public boolean testefeld(int p1[][], int hoch, int tief, int schiff[], int i) {
		boolean test = true;
		if (hoch - (schiff[i]) >= 0 && hoch + (schiff[i]) <= 9 && tief - 1 >= 0 && tief + 1 <= 9) {
			if (p1[(hoch + 1)][tief] != 1 && p1[(hoch - 1)][tief] != 1 && p1[(hoch)][tief] != 1) {
				for (int a = 0; a <= (schiff[i]); a++) {
					if (test == true) {
						if (p1[(hoch + a)][tief] != 1 && p1[(hoch)][tief] != 1) {
							if (p1[hoch + a][tief - 1] == 1 || p1[hoch + a][tief + 1] == 1 || p1[hoch + a][tief] == 1) {

								return false;
							}
						} else {

							return false;
						}
					} else {
						return false;
					}
				}
				return true;

			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void ausgabe(int p1[][], String tabelle[]) {
		System.out.print(" ");
		for (int i = 0; i < 10; i++) {
			System.out.print("  " + (i+1));
		}
		System.out.println();
		for (int x = 0; x < p1.length; x++) {
			System.out.print(tabelle[x]);
			for (int y = 0; y < p1.length; y++) {
				System.out.print("  " + p1[x][y]);
				if (p1[x][y] == 1) {

				}
			}
			System.out.println();
		}
	}

	public boolean testrunde(int p1[][], int p2[][]) {
		int testr1 = 0;
		int testr2 = 0;
		for (int x = 0; x < p1.length; x++) {
			for (int y = 0; y < p1[0].length; y++) {
				if (p1[x][y] == 1) {
					testr1 = 1;
				}
				
				if (p2[x][y] == 1) {
					testr2 = 1;
				}
				
			} // end of for
		} // end of for
		if (testr1==0||testr2 == 0) {
			return false;
		}
		else {
			return true;
		}
			
		
	}

	public boolean schussp1(int p1[][], int x, int y) {
		if (p1[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean schussp2(int p2[][], int x, int y) {
		if (p2[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}

}

//System.out.print("\b\b\b\b\b");