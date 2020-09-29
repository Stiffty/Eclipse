package threads;

import java.util.Random;

public class QuadratzahlGenerator implements Runnable{
	private int n;
	private int waitTime;
	private Random rnd;
	
	public QuadratzahlGenerator(int n, int waitTime) {
		super();
		this.n = n;
		this.waitTime = waitTime;
		rnd = new Random();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int rndZahl = rnd.nextInt(n);
		System.out.println("QuadratZahl: " + rndZahl*rndZahl);
		
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
