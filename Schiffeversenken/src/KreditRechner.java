import java.util.*;
  import java.lang.Math;

public class KreditRechner {
  public KreditRechner() {
    double darlehen,tilgung, zinssatz, zins, annuit;
    double summeAnnu=0, summeZins=0, summeTilgung=0;
    int jahre;
Scanner sc = new Scanner (System.in);

    System.out.print("\nDarlehenssumme in Euro: ");
    darlehen = sc.nextDouble();
    System.out.print("\nZinssatz in %: ");
    zinssatz = sc.nextDouble();
    System.out.print("\nAnzahl Jahre: ");
    jahre = sc.nextInt();
tilgung = getRatentilgung(darlehen, jahre); 
    System.out.println("\n\n\n");

    //Formatierte Ausgabe: Linksbündige Ausgabe mit Anzahl Stellen
    System.out.printf("%-6s | %-9s | %-9s | %-9s | %-9s\n", "Jahr","Zins","Tilgung","Annuität","Restschuld"); 

    for (int i=1;i<=jahre ; i++ ) {
      zins = getZinsen(darlehen,zinssatz);
      summeZins += zins;                    //Für die Gesamtausgabe = unterste Zeile der Tabelle

      annuit = getAnnuitaet(zins, tilgung); 
      summeAnnu += annuit;

      darlehen = getRestschuld(darlehen, tilgung);

      summeTilgung += tilgung;

      System.out.printf("---------------------------------------------------------\n");
      System.out.printf("%-6d | %-10.2f| %-10.2f| %-10.2f| %-10.2f %n", i, zins, tilgung, annuit, darlehen);
    } // end of for
System.out.printf("*\n");
    System.out.printf("%-6s | %-10.2f| %-10.2f| %-10.2f| %-10.2f %n", "Gesamt", summeZins, summeTilgung, summeAnnu, darlehen);
    System.out.printf("---------------------------------------------------------\n\n");

    double eff = getEffektivZins(summeZins, summeTilgung,jahre);
    System.out.printf("%s %3.2f %s", "Der effektive Jahreszins beträgt: ", eff, "%"); //%3.2f --> Kommazahl mit zwei Nachkommastellen
    System.out.println();
public static void main(String[] args) {

    new KreditRechner();

  } // end of main
double getZinsen(double betrag, double zinssatz) {
    double zins = betrag * (zinssatz/100);
    zins = Math.round(zins100)/100.;
    return zins;
  }

  double getRestschuld(double kredit, double tilgung) {
    double rest = kredit - tilgung;
    rest = Math.round(rest100)/100.; 
    return rest;
  }

  double getRatentilgung (double schulden, int jahre) {
    double abzahlen = schulden/jahre;
    abzahlen = Math.round(abzahlen100)/100.;
    return abzahlen;
  }

  double getAnnuitaet(double zinsen, double tilgung) {
    double annu = zinsen + tilgung;
    annu = Math.round(annu100)/100.;
    return annu;
  }

  double getEffektivZins(double kreditKosten, double nettodarlehen, int laufzeit) {
    double effzins = (kreditKosten / nettodarlehen)(24./(laufzeit12+1)) *100;
    return effzins;
  }

public static void main(String[] args) {
	focdownloads.blogspot.com
}
} // end of class MethodTes