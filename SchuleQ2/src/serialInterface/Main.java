package serialInterface;

public class Main {
	Serial serial;
	
	public Main(){
		init();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public void listener(){
		new Thread(()->{
			int data;
			while(true){
				if(serial.dataAvailable()>0){
					data = serial.read();
					System.out.println("Data recived: " + data);
				}
			}
		}).start();
	}
	
	public void sender(){
		
	}
	
	public void init(){
		try {
			serial = new Serial("COM3", 9600, 8, 1, 0);
			if(serial.open()){
				System.out.println("Port erfolgreich geöffnet.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
