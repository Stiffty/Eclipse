package serialInterface;

public class SerialEcho {

	Serial serial;
	Serial serial1;

	public SerialEcho() {
		init();
		listener();
		listener1();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SerialEcho();
	}

	public void listener() {
		new Thread(() -> {
			int data;
			while (true) {
				if (serial.dataAvailable() > 0) {
					data = serial.read();

					if ((char) data == '§') {
						System.out.println();
					} else {
						System.out.print((char) data);
					}
					sender((char) data);
				}
			}
		}).start();
	}

	public void sender(char str) {
		String data = String.valueOf(str);
		String stopbyte = "§";

		serial1.writeBytes(data.getBytes());
		//serial1.writeBytes(stopbyte.getBytes());

	}

	public void listener1() {
		new Thread(() -> {
			int data;
			while (true) {
				if (serial1.dataAvailable() > 0) {
					data = serial1.read();

					if ((char) data == '§') {
						System.out.println();
					} else {
						System.out.print((char) data);
					}
					sender1((char) data);
				}
			}
		}).start();
	}
	
	public void sender1(char str) {
		String data = String.valueOf(str);
		String stopbyte = "§";

		serial.writeBytes(data.getBytes());
		//serial1.writeBytes(stopbyte.getBytes());

	}
	public void init() {
		try {
			serial = new Serial("COM3", 9600, 8, 1, 0);
			if (serial.open()) {
				System.out.println("Port erfolgreich geöffnet.");
			}
			serial1 = new Serial("COM4", 9600, 8, 1, 0);
			if (serial1.open()) {
				System.out.println("Port 1 erfolgreich geöffnet.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
