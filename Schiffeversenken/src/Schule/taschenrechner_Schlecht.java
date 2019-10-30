package Schule;

//2018-10-15 Achtnich
//*******************
//
//Taschenrechner
import java.util.*;
import java.lang.Math;
public class taschenrechner_Schlecht {

public static void main(String[] args) {
  double r;
  double u;
  double a;
  double d;
  double g;
  double h;
  double b;
  double c;
  double ergebnis;
  int dez;
  int bin;
  int hex;
  int eingabe;
  int test = 1;
  int test1 = 0;
  int test2 = 0;
  int leer = 13;
  int einheitue;
  int m = 1;
  int k;
  String einheit = "leer";
  int[] hexergebnis = new int[20];
  
  Scanner sc = new Scanner(System.in);
  
  while (test == 1) { 
    
    
    System.out.println("  ______                __                              __                   ");
    System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
    System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
    System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
    System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
    System.out.println();
    System.out.println();
    
    System.out.println("Bitte wählen sie eine rechenmethode.");
    System.out.println("1 für Kreisfläche");
    System.out.println("2 für Dreiecksfläche");
    System.out.println("3 für Programmierrechner");
    System.out.println("4 für Pythagoras");
    
    for (int i = 1;i<=leer ;i++ ) {
      System.out.println(" ");
    }
    eingabe = sc.nextInt();
    
    if (eingabe < 3){
      
      System.out.println("  ______                __                              __                   ");
      System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
      System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
      System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
      System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
      System.out.println();
      System.out.println();
      System.out.println("Möchten Sie ihre Eingaben in cm oder m eingeben?");
      System.out.println("Bitte geben Sie 1 für cm ein und 2 für m.");
      
      for (int i = 1;i<=15 ;i++ ) {
        System.out.println(" ");
      }
      einheitue = sc.nextInt();
      
      if(einheitue == 1){
        einheit = "cm";
      }
      
      else{
        einheit = "m";
      }
    }
    
    if (eingabe == 1){
      System.out.println("  ______                __                              __                   ");
      System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
      System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
      System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
      System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
      System.out.println();
      System.out.println();
      System.out.println("Bitte geben Sie 1 für die berechnung von Durchmesser (d) ein");
      System.out.println("Bitte geben Sie 2 für die berechnung von Umfang (u) ein");
      System.out.println("Bitte geben Sie 3 für die berechnung von Flächeninhalt (A) ein");
      
      for (int i = 1;i<=14 ;i++ ) {
        System.out.println(" ");
      }
      
      eingabe = sc.nextInt();
      
      
      switch (eingabe) {
        case 1 :
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie den Raduis ihres zu berechnenden Kreis ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          
          d = sc.nextInt();
          
          
          r = d/2;
          
          System.out.println("Ergebnis:  " + r +  " " + einheit);
          System.out.println("Drücken sie eine zahl um in das menu zu kommen!");
          h = sc.nextInt();
          break ;
        case 2 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie den Raduis ihres zu berechnenden Kreis ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          
          r = sc.nextInt(); 
          
          u = 2*Math.PI*r;
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");     
          }
          
          System.out.println("Ergebnis:  " + u +  " " + einheit);
          System.out.println("Drücken sie eine zahl um in das menu zu kommen!");
          h = sc.nextInt();
          break  ;
        case 3 :
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie den Raduis ihres zu berechnenden Kreis ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          r = sc.nextInt();
          
          r = r*r;
          
          a = Math.PI*r;
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          
          System.out.println("Ergebnis:  " + a +  " " + einheit);
          System.out.println("Drücken sie eine zahl um in das menu zu kommen!");
          h = sc.nextInt();
          break ;
        default: 
          leer = 13;
          
      }
    }
    
    if (eingabe == 2) {
      System.out.println("  ______                __                              __                   ");
      System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
      System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
      System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
      System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
      System.out.println();
      System.out.println();
      System.out.println(" Bitte drücken Sie 1 Dreiecksfläche mit Grundlinie und Höhe berechnen");
      
      for (int i = 1;i<=16 ;i++) {
        System.out.println(" ");
      }
      eingabe = sc.nextInt();
      
      switch (eingabe) {
        case 1 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println(" Bitte geben Sie die grundlinie (g) des Dreiecks ein. ");
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          g = sc.nextInt();
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println(" Bitte geben Sie die die Höhe h des Dreiecks ein. ");
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          h = sc.nextInt();  
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          a = 0.5*g*h;
          
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Ergebnis:  " + a +  " " + einheit);
          
          System.out.println("Drücken sie eine zahl um in das menu zu kommen!");
          
          for (int i = 1;i<=15 ;i++ ) {
            System.out.println(" ");
          }
          
          h = sc.nextInt();
          break;
        case 2 : 
          
          break;
        default: 
          leer = 13;
          
          
      }   
    }
    if (eingabe == 3){
      System.out.println("  ______                __                              __                   ");
      System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
      System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
      System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
      System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
      System.out.println();
      System.out.println();
      System.out.println(" Bitte geben Sie die gewünschte umrechnung ein.\n 1 für dez in bin \n 2 für dez in hex \n 3 für bin in hex \n 4 für bin in dez \n 5 für hex in bin \n 6 für hex in dez ");
      
      for (int i = 1;i<=10 ;i++ ) {
        System.out.println(" ");
      }
      eingabe = sc.nextInt();
      switch (eingabe) {
        case 1 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie eine Dezimale Zahl ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          
          dez = sc.nextInt();
          
          for (int i = 1;i<=25 ;i++ ) {
            System.out.println(" ");
          }
          bin = dez%2;
          System.out.print("Ergebnis: \n  " + bin);  
          while (dez != 0) { 
            dez = dez/2;
            bin = dez%2;
            System.out.print(bin);
          }
          
          System.out.println("  Drücken sie eine zahl um in das menu zu kommen!");
          h = sc.nextInt();
          
          break;
        case 2 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie eine Dezimale Zahl ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          
          
          dez = sc.nextInt();
          
          for (int i = 1;i<=25 ;i++ ) {
            System.out.println(" ");
          }
          
          hex = dez%16;
          
          hexergebnis[test1] = hex;
          
          while (dez != 0) { 
            test1++;
            
            dez = dez/16;
            hex = dez%16;
            
            hexergebnis[test1] = hex;
          }
          
          for(m = hexergebnis.length-1;m >= 0; m--) {
            
            
            if (hexergebnis[m] == 10){
              System.out.print("A");
            }
            if (hexergebnis[m] == 11){
              System.out.print("B");
            }
            if (hexergebnis[m] == 12){
              System.out.print("C");
            }
            if (hexergebnis[m] == 13){
              System.out.print("D");
            }
            if (hexergebnis[m] == 14){
              System.out.print("E");
            }
            if (hexergebnis[m] == 15){
              System.out.print("F");
            }
            if (hexergebnis[m] < 10 && hexergebnis[m]!= 0){
              System.out.print(hexergebnis[m]);
              
            }
            if(hexergebnis[m] == 0){
              
              m--;
              if (hexergebnis[m] != 0){
                m++;
                System.out.print(hexergebnis[m]);
              }
            }
            
          }
          System.out.println("\nDrücken sie eine zahl um in das menu zu kommen!");
          h = sc.nextInt();
          break;
        case 3 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie eine Binäre Zahl ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          eingabe = sc.nextInt();
          
          
          
          break;
        case 4 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie eine Binäre Zahl ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          eingabe = sc.nextInt();
          break;
        case 5 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie eine Hexadezimale Zahl ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          eingabe = sc.nextInt();
          break;
        case 6 : 
          System.out.println("  ______                __                              __                   ");
          System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
          System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
          System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
          System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
          System.out.println();
          System.out.println();
          System.out.println("Bitte geben Sie eine Hexadezimale Zahl ein.");
          
          for (int i = 1;i<=16 ;i++ ) {
            System.out.println(" ");
          }
          eingabe = sc.nextInt();
          break;
        default: 
          
      }
    }
    if (eingabe == 4) {
      System.out.println("  ______                __                              __                   ");
      System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
      System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
      System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
      System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
      System.out.println();
      System.out.println();
      System.out.println("geben Sie die Kathete a ein.");
      
      for ( int i = 1;i<=17 ;i++ ) {
        System.out.println(" ");
      }
      a = sc.nextInt() ;
      System.out.println("  ______                __                              __                   ");
      System.out.println(" /_  __/___ ___________/ /_  ___  ____  ________  _____/ /_  ____  ___  _____");
      System.out.println("  / / / __ `/ ___/ ___/ __ \\/ _ \\/ __ \\/ ___/ _ \\/ ___/ __ \\/ __ \\/ _ \\/ ___/");
      System.out.println(" / / / /_/ (__  ) /__/ / / /  __/ / / / /  /  __/ /__/ / / / / / /  __/ /    ");
      System.out.println("/_/  \\__,_/____/\\___/_/ /_/\\___/_/ /_/_/   \\___/\\___/_/ /_/_/ /_/\\___/_/     ");
      System.out.println();
      System.out.println();
      System.out.println("geben Sie die Kathete b ein.");
      
      for ( int i = 1;i<=17 ;i++ ) {
        System.out.println(" ");
      }
      
      b = sc.nextInt() ;
      
      ergebnis = (a*a + b*b) ;
      ergebnis = Math.sqrt (ergebnis);
      
      System.out.println(ergebnis + " das ist die länge Ihrer Hypotenuse c!");
      
      System.out.println("\nDrücken sie eine zahl um in das menu zu kommen!");
          h = sc.nextInt();
    }        
  }
  
}
}    


