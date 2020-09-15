package xonxoff;

import serialInterface.Serial;

public class DruckerXONXOFF {

	byte[] buffer;
	int groessebufferspeicher;
	
	int xon = 0x11;
	int xoff = 0x13;
	int etb = 0x17;
	
	Serial serial;
	
	
	public DruckerXONXOFF(int portnr) {
		// TODO Auto-generated constructor stub
		try {
			serial = new Serial("COM" + portnr, 9600,8, 1, 0);
			buffer = new byte[4];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean oeffnePort(){
		boolean suc = serial.open();
		System.out.println("Com-Port wurde geöffnet...");
		serial.write(xon);
		System.out.println("Xon wurde gesendet.");
		return suc;
		
	}

	public void empfangeTextUndDruck(){
		int dataCounter = 0;
		while(true){
			if(serial.dataAvailable()>0){
				if(dataCounter==buffer.length){
					serial.write(xoff);
					druckBufferLeer();
					dataCounter = 0;
					serial.write(xon);
				}else{
				int data = serial.read();
				if(data == etb){
					druckBufferLeer();
					serial.write(xoff);
					return;
				}
				buffer[dataCounter] = (byte) data;
				dataCounter++;
				}
			}
		}
	}
	
	private void druckBufferLeer(){
		for (int i = 0; i < buffer.length; i++) {
			System.out.print((char)buffer[i]);
		}
	}
	
	public void schliessePort(){
		serial.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DruckerXONXOFF d = new DruckerXONXOFF(3);
		d.oeffnePort();
		d.empfangeTextUndDruck();
	}

}
