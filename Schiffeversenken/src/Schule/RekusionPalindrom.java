package Schule;

import java.util.Scanner;

public class RekusionPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		String eingabe = sc.next();
		char[] Eingabe = eingabe.toCharArray();
		if(Palindrom(Eingabe, 0 , Eingabe.length-1) == true){
			System.out.println("Ihre Eingabe ist ein Palindrom");
		}else{
			System.out.println("Ihre Eingabe ist kein Palindrom");
		}
	}
	
	public static boolean Palindrom(char[] eingabe, int a ,int b){
		
		if (eingabe[a] != eingabe[b]) {
			return false;
		} else {
			if(a==b||b<a){
				return true;
			}else{
			Palindrom(eingabe, a+=1, b-=1);
			
			return true;
			}
		}
	}
}
