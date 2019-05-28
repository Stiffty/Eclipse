package Schule;

public class RekusionDualMulti {

	public RekusionDualMulti() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		umR(45);
	}
	
	public static void umR(int dez){
		int erg;
		
		if(dez == 0){
			
		}else{
			erg = dez%2;
			umR(dez/2);
			System.out.print(erg);
		}
	}
}
