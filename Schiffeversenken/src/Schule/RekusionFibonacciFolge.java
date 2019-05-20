package Schule;

public class RekusionFibonacciFolge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		folge(0,1,400);
	}

	public static void folge(int a, int b, int end){
		
		if(end == 0){
			
		}else{
			folge(b,a+=b, end-=1);
			System.out.println(b);
		}
		
	}
}
