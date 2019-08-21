package Schule;



public class Geo {

	public int breite;
	public int hoehe;
	
	public void setBreite(int n){
		this.breite = n;
	}
	public void setHoehe(int n){
		this.hoehe = n;
	}
	public int Fläche(){
		return breite*hoehe;
	}
	public void ausgabe(int n){
		if(n == 1){
			for (int i = 0; i < hoehe; i++) {
				for (int j = 0; j < breite; j++) {
					if(i == 0||i == hoehe-1){
						if(j == 0|| j == breite-1){
							System.out.print(" +");
						}else{System.out.print(" -");}
						
					}else if(j == 0||j == breite-1){
						System.out.print(" |");
					}else{
						System.out.print("  ");
					}
				}
				System.out.println("");
			}
		}else if(n == 2){
			for (int i = 0; i < hoehe; i++) {
				for (int j = 0; j < breite; j++) {
					if(j == (breite-1)-i){
						System.out.print(" *");
					}else if(i == hoehe-1){
						System.out.print(" *");
					
					}else{
						System.out.print(" ");
						
					}

				}
				for (int j = 0; j < breite; j++) {
					if(j == i-1){
						System.out.print("* ");
					}else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}
