
public class Arraytest {

	public Arraytest() {
		// TODO Auto-generated constructor stub
		int array [][] = new int [10][10];
		array = füllen(array);
		ausgabe(array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Arraytest();
	}
	public int[][] füllen(int array[][]){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array [i][j] = (j+1);
			}
		}
		return array;
	}
	public void ausgabe(int array [][]){
		for (int i = 0; i < array.length; i++) {
			System.out.println("");
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
	}

}
