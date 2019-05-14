package Schule;

import java.util.Scanner;

public class DualRechnen {

	private int eingabea;
	private int eingabeb;
	
	public DualRechnen() {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A");
		eingabea=sc.nextInt();
		
		System.out.println("b");
		eingabeb = sc.nextInt();
		
		BinZuDual();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DualRechnen();
	}
	
	public void BinZuDual(){
		int zahl = 0;
		for (int i = 0;i<=151 ;i++ ) {
		      zahl = zahl%23;
		       
		      if (zahl == 0) {
		        System.out.println("1");
		      }else {
		    	  System.out.println("0");
		      }
		      zahl = i+1;
		    }

	}

}
