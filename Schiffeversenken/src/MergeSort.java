
public class MergeSort {

	private static int[] Feld = new int[8];
	private static int[] ablage = new int[8];
	private static int div = 1;

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sortieren Einsortieren = new Sortieren();

		Feld = Sortieren.Einsortieren(8);

		Sortieren.ausgabe(Feld, 1);

		int A = 0;
		int E = 1;
		

		for (int i = 0; i < (Feld.length / 2); i++) {
			merge(A, E);
			A += 2;
			E += 2;

		}
		A = 0;
		E = 2;
		div++;
		for (int i = 0; i < (Feld.length / 2) / 2; i++) {

			merge(A, E);
			A += 4;
			E += 4;

		}
		A = 0;E=4;
		
		for (int i = 0; i < (Feld.length / 2) / 4; i++) {

			merge(A, E);
			

		}

		Sortieren.ausgabe(Feld, 2);
	}

	public static void merge(int A, int E) {
		int safe;
		int swich = 1;
		int ES = E;
		int AS = A;
		for (int i = A; i < (E * div) - A; i++) {

			// ablage[A] = Feld[A];

			if (Feld[AS] > Feld[ES]) {
				safe = Feld[AS];
				Feld[AS] = Feld[ES];
				Feld[ES] = safe;
				
				
				if (ES < 7) {// Wichtig
					
						ES++;
					//AS++;
				}
				else {
					ES = 4;
				}
			
			} else if (Feld[AS] < Feld[ES]) {
				AS++;
			
			}
			
		}
	}
}
