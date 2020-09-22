import serialInterface.Main;
import serialInterface.Serial;

public class ToArudino {

	Serial serial;

	 public ToArudino() {
		init();
		listener();
		//sender();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Main();
	}

	public void listener() {
		new Thread(() -> {
			int data;
			while (true) {
				if (serial.dataAvailable() > 0) {
					data = serial.read();
					
					if((char)data == '§'){
						System.out.println();
					}else{
						System.out.print( (char)data);
					}
				}
			}
		}).start();
	}

	public void sender() {
		String data = "Hiiiii";
		String stopbyte = "§";
		while (true) {
			serial.writeBytes(data.getBytes());
			serial.writeBytes(stopbyte.getBytes());
		}
	}

	public void init() {
		try {
			serial = new Serial("COM4", 9600, 8, 1, 0);
			if (serial.open()) {
				System.out.println("Port erfolgreich geöffnet.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
