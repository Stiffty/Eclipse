package FirmaSoftVererbung;

public class fuerungsKraft extends person{

	private int bonus;
	
	public fuerungsKraft(String name, String gebdatum, int mgehalt,int bonus) {
		// TODO Auto-generated constructor stub
		super(name,gebdatum,mgehalt);
		this.bonus = bonus;
		System.out.println(gruessen());
	}
	
	@Override
	public String gruessen() {
		return "Guten Tag Liebes Personal"; 
	}

}
