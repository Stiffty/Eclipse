import java.util.*;
public class BubbleSort {

	public BubbleSort() {
		// TODO Auto-generated constructor stub
		int[] zahlen = new int[1000000];
		int[] Test = new int[1000000];
		int test = 0;
		
		Random rand = new Random();
		
		for (int i = 0; i < zahlen.length; i++) {
			test = 0;
			while (test == 0) {
				zahlen[i] = rand.nextInt(1000000);
				Test[zahlen[i]]++;
				test = 1;
				if (Test[zahlen[i]] > 1) {
					test = 0;
				}
			}
		}
		
		System.out.println("Davor");
		for (int i = 0; i < zahlen.length; i++) {
			if(i <100){
				System.out.print(zahlen[i] + " ");
				
				}
			test++; 
		}
		System.out.println("");
		
		int second = 0;
		int kleinster = 0;
		for (int i = 0; i < zahlen.length; i++) {
			
			for (int j = 0; j < zahlen.length; j++) {
				if(zahlen[j]==kleinster){
					second = zahlen[j];
					zahlen[j]=zahlen[i]; 
					zahlen[i] = second;
					
					kleinster++;
					j = zahlen.length;
				}
			}
		}
		System.out.println("Danach");
		for (int i = 0; i < zahlen.length; i++) {
			if(i <1000){
			System.out.print(zahlen[i] + " ");
			
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BubbleSort();
	}

}
