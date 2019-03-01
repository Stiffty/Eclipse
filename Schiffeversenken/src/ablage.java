(hoch+(schiff[i]-1)>9||p1[hoch][tief] == 1||p1[(hoch+(schiff[i]-1))][tief] == 1) 






if (hoch - (schiff[i] - 1) > 0) {
	if (p1[(hoch + schiff[i] - 1)][tief] == 1 || p1[(hoch - (schiff[i] - 1))][tief] == 1) {
		test1 = false;
	} else {
		test1 = true;
	}
}


/*
 * public boolean testefeldV2(int p1[][], int hoch, int tief, int schiff[], int
 * i) { boolean test = false; boolean test1 = false; boolean test2 = false;
 * 
 * if (hoch + (schiff[i] - 1) > 9 || p1[hoch][tief] == 1 || p1[(hoch +
 * (schiff[i] - 1))][tief] == 1) { test = false;
 * 
 * } else { test = true;
 * 
 * if (hoch - (schiff[i]-1) >= 0 && hoch + (schiff[i] - 1) <= 9) { for (int a =
 * 0; a < schiff[i]; a++) { if (test1 == false) { if (hoch == 0) { if (p1[(hoch
 * - (schiff[i] - 1))][tief] == 1) {
 * 
 * hoch++; test1 = false; } else { test1 = true; } } if (hoch == 9) { if
 * (p1[(hoch + schiff[i] - 1)][tief] == 1) {
 * 
 * hoch++; test1 = false; } else { test1 = true; } } else if (hoch - (schiff[i])
 * >= 0 && hoch + (schiff[i] - 1) <= 9) { if (p1[(hoch + schiff[i] - 1)][tief]
 * == 1 || p1[(hoch - (schiff[i] - 1))][tief] == 1) {
 * 
 * hoch++; test1 = false; } else { test1 = true; } }
 * 
 * } } } }
 * 
 * if (tief >= 0 && tief <= 9) { for (int a = 0; a < schiff[i]; a++) { if (hoch
 * <= 9) { if (test2 == false) { if (tief == 0) {
 * 
 * if (p1[hoch][(tief + 1)] == 1) {
 * 
 * hoch++; test2 = false; } else { test2 = true; } } if (tief == 9) {
 * 
 * if (p1[hoch][(tief - 1)] == 1) {
 * 
 * hoch++; test2 = false; } else { test2 = true; } } else if (tief > 0 && tief <
 * 9) { if (p1[hoch][(tief - 1)] == 1 || p1[hoch][(tief + 1)] == 1) {
 * 
 * hoch++; test2 = false; } else { test2 = true; } } }
 * 
 * } else { return false; }
 * 
 * } } if (test == false || test1 == false || test2 == false)
 * 
 * { return false;
 * 
 * } else { return true; }
 * 
 * }
 */























//Autor: Lukas Kirmaier
//Datum: 12.02.2019

import java.util.*;
public class Diskriminante {

public static void main(String[] args) {
 double a ; 
 double b ;
 double c ;
 double d ;

 System.out.println("Bitte geben sie a ein");
 System.out.println("Bitte geben sie b ein");
 System.out.println("Bitte geben sie c ein");

 Scanner sc = new Scanner(System.in);

 a = sc.nextInt();
 b = sc.nextInt();
 c = sc.nextInt();

 d = (b*(b–4.0)*a)*c ;


 if (d == 0) {
   System.out.println(" es gibt nur eine Lösung");
 if  (d > 0) {
     System.out.println(" es gibt zwei Lösungen");
 if  (d < 0) {
       System.out.println(" es gibt keine Lösung");

 }
 } // end of if-else


} // end of main

} // end of class Diskriminante