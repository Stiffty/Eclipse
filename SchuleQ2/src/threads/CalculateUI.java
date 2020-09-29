package threads;

public class CalculateUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ZahlGenerator started.");
		new Thread(new QuadratzahlGenerator(10, 100000000)).start();
		System.out.println("WurzelGenerator started.");
		new QuadratwurzelGenerator(100, 10).start();
		
	
	}

}
