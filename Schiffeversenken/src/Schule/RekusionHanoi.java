package Schule;

public class RekusionHanoi {

	private static int[][] one = {{4,3,2,1},
			                      {0,0,0,0},
			                      {0,0,0,0}};
	private static int stapel = 3;
	private static int y = stapel;
	public static int x = 0;
	public static int test = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ausgabe();
		lös(2,0);
		ausgabe();
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
	
	public static void lös(int xs, int ys){
		
		one[xs][ys] = one [x][y];
		one [x][y] = 0;
		y-=1;
		if(xs == 2 && ys== stapel||xs == 1 && ys== stapel){
			
		}else{
			lös(xs, ys +=1);
			
			xs = 1;
			ys = 0;
			x = 2;
		    y = stapel;
		    test++;
		    if(test == 1){
		    	ausgabe();
		    lös(xs,ys);
		    }
		}
	}
	public static void ausgabe(){
		for (int i = 0; i < one.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < one[0].length; j++) {
				System.out.print(one[i][j] + " ");
			}
		}
		System.out.println("  ");
	}
}
	
	
