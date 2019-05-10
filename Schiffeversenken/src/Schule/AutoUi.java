package Schule;
import java.lang.*;
public class AutoUi {

	private int ps[] = {200, 150, 300};
	private String Name [] = {"Mercedes", "VW", "Porsche"};
	
	public void ps(int ps,int stelle){
		this.ps[stelle] = ps;
	}
	
	public void name(String name,int stelle){
		this.Name[stelle] = name;
	}
	public void ausgabe(int stelle){
		if(stelle == 0){
			for (int i = 0; i < Name.length; i++) {
				System.out.println("Auto: "+ Name[i] +" " + ps[i]+ " KW: "+ berechneKW(ps[i]));
			}
		}
		else if(stelle >=1 && stelle<=2){
			System.out.println("Auto: "+ Name[stelle] +" " + ps[stelle]+ " KW: "+ berechneKW(ps[stelle]));
		}
	}
	private double  berechneKW(double ps){
		
		ps*=0.735499;
		
		return ps=Math.rint(ps*100)/100;
		 
	}
	
}
