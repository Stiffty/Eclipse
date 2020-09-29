package threads;

import java.util.Random;

public class QuadratwurzelGenerator extends Thread {
	private int n;
	private int waitTime;
	private Random rnd;
	
	public QuadratwurzelGenerator(int n, int waitTime) {
		super();
		this.n = n;
		this.waitTime = waitTime;
		rnd = new Random();
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
		int rndZahl = rnd.nextInt(n);
		System.out.println("QuadratWurzel: " + Math.sqrt(rndZahl));
		
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
