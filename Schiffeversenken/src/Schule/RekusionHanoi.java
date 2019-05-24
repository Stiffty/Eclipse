package Schule;

public class RekusionHanoi {

	private int[][] one = {{3,2,1},
			               {0,0,0},
			               {0,0,0}};
	
	private int n = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

	private void pressAnyKeyToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	
	public void hanoi(int x, int y,int xs,int ys){
		y = 0;
		for (int i = one[0].length; i >= 0  ; i--) {
			
			if(one[x][i] == 0){
				y = i;
			}
		}
		
		if(){
			
		}else{
			
		}
	}
	
	public void leer(){
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one[0].length; j++) {
				if(one[i][j] == 0&&j == 0){
					one[i][j] = n;
				}
			}
		}
	}
	public void ver(){
		
	}
}
