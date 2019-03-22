import java.util.*;
public class Rechner {

	public Rechner() {
		// TODO Auto-generated constructor stub
		int x;
		int y;
		boolean test = true;
		Scanner sc =new Scanner(System.in);
		
		while (test == true){
		System.out.println("X");
		x = sc.nextInt();
		System.out.println("Y");
		y = sc.nextInt();
		
		if (prüfung(x, y) == true) {
			int ergebnis = rechner(x, y);
			System.out.println("Ergebnis: " + ergebnis);
			test = false;
		}else {
			System.out.println("Eingabe ungülig");
		}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rechner();

	}
public boolean prüfung (int x, int y) {
	if (x <= 10 &&y <= 10) {
		return true;
	}else {
		return false;
	}
}
public int rechner (int x, int y){
	return (x+y);
}
}
