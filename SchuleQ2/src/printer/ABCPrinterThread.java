package printer;

public class ABCPrinterThread extends Thread {

	private char text;
	private int ms;
	
	public ABCPrinterThread(char text, int ms) {
		super();
		this.text = text;
		this.ms = ms;
		this.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println(this.getId() + " " + text);
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		super.interrupt();
		System.out.println(this.getId() + " Interrupted");
		text = 'E';
	}
	
	

	
	
	
	
}
