package xonxoff;

import serialInterface.Serial;

public class SenderXONXOFF {
	
	int xon = 0x11;
	int xoff = 0x13;
	int etb = 0x17;
	
	Serial serial;
	
	
	public SenderXONXOFF(int portnr) {
		// TODO Auto-generated constructor stub
		try {
			serial = new Serial("COM" + portnr, 9600, 8, 1, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean oeffnePort(){
		serial.open();
		System.out.println("Com-Port wurde geˆffnet...");
		while(true){
		if(serial.dataAvailable()>0){
			int  data = serial.read();
			if(data == xon){
				System.out.println("Xon empfangen");
				return true;
			}
			System.out.println("Fehler beim erstellen der Schnittstelle.");
			return false;
		}
		}
	}

	public int sendeText(String text){
		byte[] buffer = text.getBytes();
		for (int i = 0; i < buffer.length; i++) {
			if(serial.dataAvailable()>0){
				if(serial.read() == xon){
					serial.write(buffer[i]);
				}
			}else{
				serial.write(buffer[i]);
			}
		}
		serial.write(etb);
		while(true){
			if(serial.dataAvailable()>0){
		if(serial.read() == xoff){
			return buffer.length;
		}else{
			System.out.println("Fehler beim abschlieﬂen der Sendung.");
			return 0;
		}
		}
		}
	}
	public void schliessePort(){
		serial.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SenderXONXOFF s = new SenderXONXOFF(5);
		s.oeffnePort();
		s.sendeText("Halliihallo");
	}

}
