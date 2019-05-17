package Schule;

import java.util.Scanner;

public class Rekusion {

	private Scanner sc = new Scanner(System.in);
	public Rekusion() {
		// TODO Auto-generated constructor stub
		eingabe();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rekusion();
	}
	
	public void eingabe(){
		String eingabe= sc.next();
		
		
		if(eingabe.equals("#")){
			
		}else{
			eingabe();
			System.out.print(eingabe + " ");
		}
	}
}
