package Schule;

import java.util.ArrayList;

public class DualMultiplizierung {

	public DualMultiplizierung() {
		// TODO Auto-generated constructor stub
		ArrayList<String> ergebnis = new ArrayList<>();
		ArrayList<Integer> eingabeA = new ArrayList<>();
		eingabeA.add(1);
		eingabeA.add(0);
		eingabeA.add(1);
		eingabeA.add(1);
		
		ArrayList<Integer> eingabeB = new ArrayList<>();
		eingabeB.add(0);
		eingabeB.add(0);
		eingabeB.add(1);
		

		ergebnis = DualMultiplizierungBer(eingabeA, eingabeB);

		for (int i = ergebnis.size() - 1; i > -1; i--) {
			System.out.print(ergebnis.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DualMultiplizierung();
	}

	public ArrayList<String> DualMultiplizierungBer(ArrayList<Integer> eingabeA, ArrayList<Integer> eingabeB) {
		// TODO Auto-generated constructor stub
		int speicher = 0;
		ArrayList<String> ergebnis = new ArrayList<>();

		for (int i = 0; i < eingabeA.size(); i++) {
			try {
				if (eingabeA.get(i).equals(0) && eingabeB.get(i).equals(0)) {

					if (speicher == 1) {
						ergebnis.add("1");
						speicher = 0;
					} else {
						ergebnis.add("0");
						speicher = 0;
					}
				}

				if (eingabeA.get(i).equals(1) && eingabeB.get(i).equals(1)) {

					if (speicher == 1) {
						ergebnis.add("1");
						speicher = 1;
					} else {
						ergebnis.add("0");
						speicher = 1;
					}

				}

				if (eingabeA.get(i).equals(1) && eingabeB.get(i).equals(0)) {

					if (speicher == 1) {
						ergebnis.add("0");
						speicher = 1;
					} else {
						ergebnis.add("1");
						speicher = 0;
					}
				}

				if (eingabeA.get(i).equals(0) && eingabeB.get(i).equals(1)) {

					if (speicher == 1) {
						ergebnis.add("0");
						speicher = 1;
					} else {
						ergebnis.add("1");
						speicher = 0;
					}
				}
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				try {
					if (eingabeA.get(i).equals(1)) {

						if (speicher == 1) {
							ergebnis.add("0");
							speicher = 1;
						} else {
							ergebnis.add("1");
							speicher = 0;
						}

					}
				} catch (IndexOutOfBoundsException e1) {
					// TODO: handle exception
					if (speicher == 1 && eingabeB.get(i).equals(1)) {

						if (speicher == 1) {
							ergebnis.add("0");
							speicher = 1;
						} else {
							ergebnis.add("1");
							speicher = 0;
						}

					}
				}

			}
		}
		ergebnis.add("1");
		return ergebnis;
	}

}
