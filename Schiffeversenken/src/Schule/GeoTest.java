package Schule;

import java.util.Scanner;

public class GeoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Geo g1 = new Geo();
		
		System.out.print("Breite");
		g1.setBreite(sc.nextInt());
		
		System.out.print("Höhe");
		g1.setHoehe(sc.nextInt());
		
		g1.ausgabe(2);
		
	}

}
