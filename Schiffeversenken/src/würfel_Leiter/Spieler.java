package würfel_Leiter;

public class Spieler {

	private String name;
	private int anzGewonneneSpiele;
	private Würfel wuerfel[];
	private Leiterkarte leiterkarte;
	
	public Spieler(String n, Würfel wuerfel[]) {
		// TODO Auto-generated constructor stub
		this.name = n;
		
		for (int i = 0; i < wuerfel.length; i++) {
			wuerfel[i] = null;
		}
	}

	public boolean wuerfeln (){
		
	}
}
