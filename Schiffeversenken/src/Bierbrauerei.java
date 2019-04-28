import java.util.*;
public class Bierbrauerei {
  public Bierbrauerei () {
    int bier [][] = new int [5][7];
    bier = füllen(bier);
    ausgabe(bier);
   }


  public static void main(String[] args) {
    double b;   //Bierpeis  0,36€
    double k;   //kosten pro Bier 0,3€
    double m;   //Miete 10000€
    double s;   //sonstige kosten 5500€
    double a1;  //arbeiter 1 12€ 
    double a2;  //arbeiter 2 8,50€ 
    double a3;  //arbeiter 3 8,50€ 
    double a4;  //arbeiter 4 8,50€ 


    Scanner sc = new Scanner(System.in);
    System.out.println("geben sie den Preis des Bieres an.");
    b = sc.nextDouble();
    System.out.println("geben sie die Kosten des Bieres an.");
    k = sc.nextDouble();
    System.out.println("geben sie die Miete der Brauerei pro Monat an.");
    m = sc.nextDouble();
    System.out.println("geben sie die sonstigen Kosten pro Monat an.");
    s = sc.nextDouble();
    System.out.println("geben sie den Lohn je Stunde des ersten arbeiters an.");
    a1 = sc.nextDouble();
    System.out.println("geben sie den Lohn je Stunde des zweiten arbeiters an.");
    a2 = sc.nextDouble();
    System.out.println("geben sie den Lohn je Stunde des dritten arbeiters an.");
    a3 = sc.nextDouble();
    System.out.println("geben sie den Lohn je Stunde des vierten arbeiters an.");
    a4 = sc.nextDouble();


    new Bierbrauerei();


  } // end of main
public int[][] füllen (int bier[][]) {
    bier[1][1] = 20000; bier[2][1] = 21000; bier[3][1] = 23000; bier[4][1] = 20000;//Alle ,minus 1
    bier[1][2] = 25000; bier[2][2] = 26000; bier[3][2] = 28000; bier[4][2] = 27000;
    bier[1][3] = 22000; bier[2][3] = 19000; bier[3][3] = 17000; bier[4][3] = 22000;
    bier[1][4] = 22000; bier[2][4] = 21000; bier[3][4] = 23000; bier[4][4] = 19000;
    bier[1][5] = 40000; bier[2][5] = 42000; bier[3][5] = 45000; bier[4][5] = 41000;
    bier[1][6] = 48000; bier[2][6] = 44000; bier[3][6] = 40000; bier[4][6] = 45000;
    return bier;
    }

  public void ausgabe(int test[][]) {
    for (int x=0;x<test.length;x++ ) {
      System.out.println("");
      for (int y=0;y<test[0].length;y++ ) {
        System.out.println(test[x][y] + " ");
      } // end of for
    } // end of for
  }

} // end of class Bierbrauerei