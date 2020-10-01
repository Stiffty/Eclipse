package sensorSystem;

import serialInterface.Serial;

public class Kontrollraum {

	private int alarmstufe;
	private double temperatur;
	private boolean statusBetrieb;
	
	private Serial sensorCom;
	private Serial aktorCom;
	
	public Kontrollraum() {
		alarmstufe = 0;
		temperatur = 0;
		statusBetrieb = true;
	}
	
	public boolean init(int portNrSensor,int portNrAktor){
		try {
			sensorCom = new Serial("COM" + portNrSensor, 9600, 8, 1, 0);
		
		if (sensorCom.open()) {
			System.out.println("Port erfolgreich geöffnet.");
			new SensorThread(this).start();
		}
		aktorCom = new Serial("COM" + portNrAktor, 9600, 8, 1, 0);
		if (aktorCom.open()) {
			System.out.println("Port 1 erfolgreich geöffnet.");
			new AktorThread(this).start();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String toString() {
		return "Kontrollraum [alarmstufe=" + alarmstufe + ", temperatur=" + temperatur + ", statusBetrieb="
				+ statusBetrieb + ", sensorCom=" + sensorCom + ", aktorCom=" + aktorCom + "]";
	}

	public int getAlarmstufe() {
		return alarmstufe;
	}

	public void setAlarmstufe(int alarmstufe) {
		this.alarmstufe = alarmstufe;
	}

	public double getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(double temperatur) {
		this.temperatur = temperatur;
	}

	public boolean isStatusBetrieb() {
		return statusBetrieb;
	}

	public void setStatusBetrieb(boolean statusBetrieb) {
		this.statusBetrieb = statusBetrieb;
	}

	public Serial getSensorCom() {
		return sensorCom;
	}

	public void setSensorCom(Serial sensorCom) {
		this.sensorCom = sensorCom;
	}

	public Serial getAktorCom() {
		return aktorCom;
	}

	public void setAktorCom(Serial aktorCom) {
		this.aktorCom = aktorCom;
	}
	
	
	
}
