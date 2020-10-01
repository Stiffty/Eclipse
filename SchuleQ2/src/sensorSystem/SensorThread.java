package sensorSystem;

import serialInterface.Serial;

public class SensorThread extends Thread {

	private Kontrollraum kontrollraum;

	public SensorThread(Kontrollraum kontrollraum) {
		super();
		this.kontrollraum = kontrollraum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Serial com = kontrollraum.getSensorCom();

		while (true) {
			com.write(22);
			if (com.dataAvailable() > 0) {
				kontrollraum.setTemperatur((com.read() / 5) * 100);
				System.out.println("recived");
			}
				System.out.println(kontrollraum.getTemperatur());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
