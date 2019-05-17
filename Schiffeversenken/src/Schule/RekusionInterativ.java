package Schule;

public class RekusionInterativ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interativ(251,0);
	}
	public static void Interativ(int zahl,int erg){
		
		
		if (zahl == 0) {
			
		}else{
			erg= erg+ zahl% 10;
			Interativ(zahl/=10,erg);
			System.out.println(erg);
		}
	}
}
