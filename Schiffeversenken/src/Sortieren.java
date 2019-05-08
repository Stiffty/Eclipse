import java.util.Random;

public class Sortieren {

	private static int test = 0;
	public static int[] Einsortieren(int länge) {
		// TODO Auto-generated constructor stub
		
		int[] zahlen = new int[länge];
		int[] Test = new int[länge];
		int test = 0;
		
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
		return zahlen;
	}
	
	public static void ausgabe(int[] zahlen, int VN) {
		if(VN == 1) {
		System.out.println("Davor");
		}
		else{
			System.out.println("Danach");
		}
		for (int i = 0; i < zahlen.length; i++) {
			if (i < 100) {
				System.out.print(zahlen[i] + " ");

			}
			test++;
		}
		System.out.println("");
	}

}
