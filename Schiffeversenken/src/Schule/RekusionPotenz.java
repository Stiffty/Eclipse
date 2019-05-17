package Schule;

public class RekusionPotenz {

	private static int potz;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		potz = 2;
		Potenz(potz,21);
	}
	
	public static void Potenz(double zahl, int pot){
		
		if(pot==0){
			
		}else{
			if(pot <0){pot+=1;}else{pot-=1;}
			Potenz((zahl*potz),pot);
			System.out.println(zahl);
			
		}
	}
}
