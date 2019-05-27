package Schule;

import java.util.Scanner;

public class Caesar {

	public Caesar() {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		String eingabe = sc.nextLine();
		char[] eingabech = eingabe.toCharArray();
		int verschiebung = sc.nextInt();
		byte[] bytes = eingabe.getBytes("US-ASCII");
		for (int i = 0; i < eingabech.length; i++) {
			bytes[i]+=1;	
			}
		
		
	    
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
