
public class MergeSort {

	private static int[] Feld = new int[8];
	private static int[] ablage = new int[8];
	private static int div = 1;
	private static int div2 = 1;

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
		A = 0;
		E=4;
		
		for (int i = 0; i < (Feld.length / 2) / 4; i++) {

			//merge(A, E);
			A+=8;
			E+=8;

		}

		Sortieren.ausgabe(Feld, 2);
	}

	public static void merge(int A, int E) {
		int safe;
		int swichE = 0;
		int swichA = 1;
		int ES = E;
		int AS = A;
		int []kon = new int[8];
		for (int i = 0; i < (E * div) - (A*div); i++) {

			// ablage[A] = Feld[A];
			
			
			
			if (Feld[AS] > Feld[ES]) {
				safe = Feld[AS];
				Feld[AS] = Feld[ES];
				Feld[ES] = safe;
				
				if(swichE == 1){
				if (ES < 7) {// Wichtig
					
						ES++;
						
						swichE=0;
					//AS++;
				}else {
					AS++;
				}
				}else{
					if(AS<7){
					AS++;
					swichE=1;
					}
				}
			} else if (Feld[AS] < Feld[ES]) {
				
				if(swichA == 1){
					if (AS < 7) {// Wichtig
						
							
							
							swichA=0;
							swichE=1;
						AS++;
					}
					else {
						
						swichA=0;
					}
					}else{
						if(ES<7){
						ES++;
						swichA = 1;
						}else {
							A++;
						}
						
					}
			
			}
			
		}
		
	}
}
