import java.util.Random;
import java.util.Scanner;
import java.lang.*;

public class SchiffeversenkenPvK {
	public SchiffeversenkenPvK() {

		int p1[][] = new int[10][10];
		int p2[][] = new int[10][10];
		int p3[][] = new int[10][10];
		int p4[][] = new int[10][10];
		String tabelle[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		int schiff[] = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
		int hoch;
		int tief;
		boolean treffer = true;
		boolean oben = false;
		boolean unten = false;
		boolean rechts = false;
		boolean links = false;
		int getroffen = 1;
		int getroffentest = 0;
		int xS = 0;
		int yS = 0;
		int getroffenFail = 0;

		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		for (int x = 0; x < p1.length; x++) {
			for (int y = 0; y < p1[0].length; y++) {
				p1[x][y] = 0;
				p2[x][y] = 0;
				p3[x][y] = 0;
				p4[x][y] = 0;
			}
		}

		for (int i = 0; i < schiff.length; i++) {
			hoch = rand.nextInt(10);
			tief = rand.nextInt(10);
			int waagodersenk = rand.nextInt(2);
			if (waagodersenk == 1) {
				if (testefeldsenk(p1, hoch, tief, schiff, i) == false) {
					hoch = rand.nextInt(10);
					tief = rand.nextInt(10);
					i = i - 1;

				} else {
					for (int a = 0; a < (schiff[i]); a++) {
						p1[(hoch + a)][(tief)] = 1;

					}

				}
			} else {
				if (testefeldwaag(p1, hoch, tief, schiff, i) == false) {
					hoch = rand.nextInt(10);
					tief = rand.nextInt(10);
					i = i - 1;

				} else {
					for (int a = 0; a < (schiff[i]); a++) {
						p1[(hoch)][(tief + a)] = 1;

					}

				}
			}

		}
		for (int i = 0; i < schiff.length; i++) {
			hoch = rand.nextInt(10);
			tief = rand.nextInt(10);
			int waagodersenk = rand.nextInt(2);
			if (waagodersenk == 1) {
				if (testefeldsenk(p2, hoch, tief, schiff, i) == false) {
					hoch = rand.nextInt(10);
					tief = rand.nextInt(10);
					i = i - 1;

				} else {
					for (int a = 0; a < (schiff[i]); a++) {
						p2[(hoch + a)][(tief)] = 1;

					}

				}
			} else {
				if (testefeldwaag(p2, hoch, tief, schiff, i) == false) {
					hoch = rand.nextInt(10);
					tief = rand.nextInt(10);
					i = i - 1;

				} else {
					for (int a = 0; a < (schiff[i]); a++) {
						p2[(hoch)][(tief + a)] = 1;

					}

				}
			}

		}

		// KIP1
		int x = 0;
		int y = 0;
		int schwierigkeit = 102;
		int normal;
		boolean schwer = true;
		while (schwierigkeit>101 || schwierigkeit <1){
		System.out.println("Um die Schwierigkeit einzustellen geben sie eine Zahl"
				+ " zwischen 1 und 100 an Wobei 1 Höllenschwer ist. Wenn sie normal spie"
				+ "len wollen geben sie 101 an");
		schwierigkeit = sc.nextInt();
		if (schwierigkeit == 101) {
			schwer = false;
		}
		}
		int counter = 0;
		String eingabe = "NULL";
		ausgabe(p3, tabelle);
		System.out.println("*******************************");
		ausgabe(p1, tabelle);
		while (testrunde(p1, p2) == true) {
			treffer = true;
			while (treffer == true) {
				treffer = false;
				while (treffer == false) {
					treffer = true;
					System.out.println("P1");
					System.out.println("Bitte geben sie Ihre Schusskoordinaten ein");
					System.out.println("X");
					y = (sc.nextInt() - 1);
					System.out.println("Y");
					eingabe = sc.next();
					eingabe = eingabe.toUpperCase();
					if (eingabe.equals("A")) {
						x = 0;
					} else if (eingabe.equals("B")) {
						x = 1;
					} else if (eingabe.equals("C")) {
						x = 2;
					} else if (eingabe.equals("D")) {
						x = 3;
					} else if (eingabe.equals("E")) {
						x = 4;
					} else if (eingabe.equals("F")) {
						x = 5;
					} else if (eingabe.equals("G")) {
						x = 6;
					} else if (eingabe.equals("H")) {
						x = 7;
					} else if (eingabe.equals("I")) {
						x = 8;
					} else if (eingabe.equals("J")) {
						x = 9;
					} else {
						treffer = false;
					}

					if (x > 10 || x < 0 || y > 10 || y < 0) {
						System.out.println("Ihre Eingabe ist ungültig. Bitte wiederholen Sie diese.");
						treffer = false;
					}
					if (p3[x][y] == 3 || p3[x][y] == 4) {
						System.out
								.println("Hier haben Sie schon hingeschschossen. Bitte wiederholen sie ihre Eingabe.");
						treffer = false;
					}

				}

				if (schussp1(p2, x, y) == true) {
					p3[x][y] = 4;
					p2[x][y] = 4;
					ausgabe(p3, tabelle);
					System.out.println("*******************************");
					ausgabe(p1, tabelle);
					System.out.println("Treffer");
					System.out.println("Schusskoordinate = " + (y + 1) + " " + (eingabe));
					treffer = true;
				} else {
					p3[x][y] = 3;
					p2[x][y] = 3;
					System.out.println("P1");
					ausgabe(p3, tabelle);
					System.out.println("*******************************");
					ausgabe(p1, tabelle);
					System.out.println("Verfehlt");
					System.out.println("Schusskoordinate = " + (y + 1) + " " + (eingabe));
					treffer = false;
				}
			}

			// KIP2

			while (treffer == false) {
				x = xS;
				y = yS;
				if (oben == false && unten == false && rechts == false && links == false
						|| oben == true && unten == true && rechts == true && links == true) {
					oben = false;
					unten = false;
					rechts = false;
					links = false;
					getroffen = 1;
                    xS = x;
                    yS = y;
					getroffentest = 0;

					x = rand.nextInt(10);
					y = rand.nextInt(10);
					if (p2[x][y] == 3 || p2[x][y] == 4) {
						treffer = false;
					}
					if (schwer == true) {
						normal = rand.nextInt(schwierigkeit) + 1;
						if (normal == 1) {
							for (int i = 0; i < p1.length; i++) {
								for (int a = 0; a < p1[0].length; a++) {
									if (p1[i][a] == 1) {
										x = i;
										y = a;
										a = 9;
										i = 9;
									}
								}
							}
						}
					}
				}
				
				counter = 0;
				treffer = true;
				
			}
			while (treffer == true) {
				System.out.println("Boom Boom!! Ihr Gegner hat geschossen.");
				if (schussp2(p1, x, y) == true) {
					p4[x][y] = 4;
					p1[x][y] = 4;
					// System.out.println("P2");
					// ausgabe(p4, tabelle);
					// ausgabe(p2, tabelle);
					// System.out.println("Schusskoordinate = " + x + " " + y);
					// System.out.println("Treffer");
					treffer = true;

					switch (getroffen) {
					case 1:
						x++;
						getroffentest = 1;
						counter++;
						oben = true;
						break;

					case 2:
						
						x--;
						getroffentest = 2;
						counter++;
						unten = true;
						getroffenFail = 0;
						break;
					case 3:
						
						y--;
						getroffentest = 3;
						counter++;
						links = true;
						getroffenFail = 0;
						break;
					case 4:
						
						y++;
						getroffentest = 4;
						counter++;
						rechts = true;
						getroffenFail = 0;
						break;
					default:
						break;
					}

					/*
					 * if (p1[x + 1][y] == 1 || p1[x - 1][y] == 1) { if (p1[x + 1][y] == 0) { x = x
					 * - counter; x--; } else { x++; counter++; } } else { if (p1[x][y + 1] == 0) {
					 * y = y - counter; y--; } else { y++; counter++; } }
					 */

					/*
					 * if (p2[(x + 1)][y] == 1) { counter++; x++; } else { x = x - counter; counter
					 * = 0; x--;
					 * 
					 * }
					 */
				} else {
					

					p4[x][y] = 3;
					p1[x][y] = 3;
					if (oben == true && unten == true) {
						rechts = true;
						links = true;
					}else if (rechts == true&&links == true) {
						oben = true;
						unten =  true;
					}
					if (getroffenFail == 1) {
						getroffentest++;
					}
					if (getroffentest == 1) {
						getroffen = 2;
						xS = (x - counter) -1 ;
						yS = y;
						getroffenFail = 1;
						if (counter == 0) {
							unten = true;
						}
						
					} else if (getroffentest == 2) {
						getroffen = 3;
						xS = (x + counter)+1 ;
						yS = y-1;
						getroffenFail = 1;
						if (counter == 0) {
							links = true;
						}
					}
					else if (getroffentest == 3) {
						getroffen = 4;
						xS = x;
						yS = (y + counter)+2;
						getroffenFail = 1;
						if (counter == 0) {
							rechts = true;
						}
					}else if (getroffentest == 4) {
						getroffen = 4;
						
					}
					// System.out.println("P2");
					// ausgabe(p4, tabelle);
					// ausgabe(p2, tabelle);
					// System.out.println("Verfehlt");
					// System.out.println("Schusskoordinate = " + x + " " + y);
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
		new SchiffeversenkenPvK();
	}

	public boolean testefeldsenk(int p1[][], int hoch, int tief, int schiff[], int i) {
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

	public boolean testefeldwaag(int p1[][], int hoch, int tief, int schiff[], int i) {
		boolean test = true;
		if (tief - (schiff[i]) >= 0 && tief + (schiff[i]) <= 9 && hoch - 1 >= 0 && hoch + 1 <= 9) {
			if (p1[(hoch)][tief + 1] != 1 && p1[(hoch)][tief - 1] != 1 && p1[(hoch + 1)][tief] != 1
					&& p1[(hoch - 1)][tief] != 1 && p1[(hoch)][tief] != 1) {
				for (int a = 0; a <= (schiff[i]); a++) {
					if (test == true) {
						if (p1[(hoch)][tief + a] != 1 && p1[(hoch)][tief] != 1) {
							if (p1[hoch - 1][tief + a] == 1 || p1[hoch + 1][tief - a] == 1 || p1[hoch][tief + a] == 1) {

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
			System.out.print("  " + (i + 1));
		}
		System.out.println();
		for (int x = 0; x < p1.length; x++) {
			System.out.print(tabelle[x]);
			for (int y = 0; y < p1.length; y++) {

				if (p1[x][y] == 1) {
					System.out.print("  I");
				}
				if (p1[x][y] == 0) {
					System.out.print("  .");
				}
				if (p1[x][y] == 3) {
					System.out.print("  O");
				}
				if (p1[x][y] == 4) {
					System.out.print("  X");
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
		if (testr1 == 0 || testr2 == 0) {
			return false;
		} else {
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
