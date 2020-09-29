package printer;

public class ABCPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ABCPrinterThread a =  new ABCPrinterThread('A', 10);
		new ABCPrinterThread('B', 10);
		print('C');
		startMonitor();
		a.interrupt();
	}
	public static void print(char text){
		System.out.println(Thread.currentThread().getId() + " " +text);
	}
	
	public static void startMonitor(){
		System.out.println("Threads aktiv: " + Thread.activeCount());
	}
}
