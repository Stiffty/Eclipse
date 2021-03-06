package baustellenSystem;

public class Bagger extends Thread{
	private String name;
	private int kapazitšt;
	private int anzahl;
	
	private Grube grube;

	public Bagger(String name, int kapazitšt, int anzahl, Grube grube) {
		super();
		this.name = name;
		this.kapazitšt = kapazitšt;
		this.anzahl = anzahl;
		this.grube = grube;
	}
	
	private void graben(){
		//synchronized (grube) {
			
		//System.out.printf("Bagger %s wird %s ausheben.%n",name,kapazitšt);
		grube.ausheben(kapazitšt);
		}
		
	//}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		int zahl = 0;
		int aushub = 0;
		while(grube.getAktuelleGroesse()>0){
		graben();
		try {
			Thread.sleep(anzahl*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zahl++;
		aushub+=kapazitšt;
	}
		System.out.printf("%s hat %s mal gebaggert und %s m^2 ausgehoben.%n",name,zahl,aushub);
	}
	
	
	
	
}
