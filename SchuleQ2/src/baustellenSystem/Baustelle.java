package baustellenSystem;

public class Baustelle {

	
	
	public Baustelle(int groesse) {
		// TODO Auto-generated constructor stub
		Grube grube = new Grube(groesse);
		
		Bagger t = new Bagger("Tomasu",1,1,grube);
		Bagger j = new Bagger("JohnDeere",2,1,grube);
		Bagger h = new Bagger("Hermann",1,1,grube);
		Bagger d = new Bagger("DrDreh",3,1,grube);
		
		t.start();
		j.start();
		h.start();
		d.start();
		
		notify();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(i+ ". ____________________");
			try {
				new Baustelle(100).wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
