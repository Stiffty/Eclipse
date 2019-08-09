
public class Hanhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("while :");
		
		int counter = 0;
		
		while (counter<10) {
			
			System.out.println(counter);
			
			counter = counter + 1;
			
		}
		
		System.out.println("for Schleife :");
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println(i);
			
		}
		
		for (int x = 1; x < 11; x++) {
			
			System.out.print(x + ".Reihe");
			
			for (int y = 1; y < 11; y++) {
				
				
				
				if(x*y > 9) {
					System.out.print(" ");
				}else {
					System.out.print("  ");
				}
				
				
				System.out.print(y*x );
				
			}
			System.out.println();
		}
		
		
		
	}

}
