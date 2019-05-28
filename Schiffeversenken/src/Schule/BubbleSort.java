package Schule;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

	private static Random rand = new Random();


	private static int[] zahlen = new int[10];


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		einSortieren();
		
		ausgabeE(1);

		BubbLeSort();//wichtig
		
		ausgabeE(2);
		
		
		einSortieren();
		
		ausgabeE(1);

		SelectionSort();//wichtig
		
		ausgabeE(2);
	}

	
	public static void BubbLeSort() {
		int speicher;

		//läuft die Länge des arrays "zahlen" durch
		for (int i = 0; i < zahlen.length; i++) {
			//läuft die Länge des arrays "zahlen" durch
			for (int j = 0; j < zahlen.length; j++) {
				//wenn die zahl an Stelle J im array größer ist als ie zahl an Stelle i im Array die zahlen tauschen
				if (zahlen[j] > zahlen[i]) {
					speicher = zahlen[i];
					zahlen[i] = zahlen[j];
					zahlen[j] = speicher;
					
				}
				
			}
		}
	}

	public static void SelectionSort() {
		int speicher;
		int min = 1;
		int minS = 0;
		boolean test = true;
		
		//läuft die Länge des arrays "zahlen" durch
		for (int i = 0; i < zahlen.length; i++) {
			
			
			if(min == minS) {
				while(test == true) {
					min++;
					for (int j2 = 0; j2 < zahlen.length; j2++) {
						if(min == zahlen[j2]) {
							test = false;
							
						}
					}
					
				}
			}else {
			min = minS;
			}
			//läuft die Länge des arrays "zahlen" durch
			for (int j = 0; j < zahlen.length; j++) {
				test = true;
				if (zahlen[j] == min&&i!=j) {
					speicher = zahlen[i];
					zahlen[i] = zahlen[j];
					zahlen[j] = speicher;
					
				}
				if(zahlen[j] == (min+1)) {
					minS = zahlen[j];
				}
				
			}
			
		}
	}
	public static void einSortieren() {
		int[] test = new int[20];
		boolean test1 = true;
		for (int i = 0; i < zahlen.length; i++) {
			test1 = true;
			while (test1 == true) {
				zahlen[i] = rand.nextInt(20);
				if (test[zahlen[i]] == 0) {
					test[zahlen[i]] = 1;
					test1 = false;
				} else {
					test1 = true;
				}
			}
		}
	}
	
	public static void ausgabeE(int VoN) {
		if(VoN!= 0) {
		if(VoN == 1) {
			System.out.println("Vorher:");
		}else {
			System.out.println("Nachher:");
		}
		}
		for (int i = 0; i < zahlen.length; i++) {
			System.out.print(zahlen[i] + " ");
		}
		System.out.println();
	}

	
}
