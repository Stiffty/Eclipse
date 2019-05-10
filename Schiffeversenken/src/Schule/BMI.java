package Schule;

public class BMI {
	private double größe;
	private double gewicht;
	private double BMi;
	
	public void größe(double i){
		this.größe = i;
	}
	public void gewicht(double i){
		this.gewicht = i;
	}
	public double BMIBer(){
		this.größe*=this.größe;
		 this.größe = this.gewicht/ this.größe;
		this.BMi=Math.rint(this.größe*100)/100; 
		return this.BMi;
	}
	public void auswertung(String MoW){
		System.out.println("Ihr BMI: " + BMi);
		System.out.println("Ihr Gewicht ist: ");
		if(MoW.equals("w")){
			if(BMi<19){
				System.out.println("Untergewicht");
			}else if(BMi>19&&BMi<24){
				System.out.println("Normalgewicht");
			}else if(BMi>24&&BMi<30){
				System.out.println("Übergewicht");
			}else if(BMi>30&&BMi<40){
				System.out.println("Adipositas(Fettleibigkeit)");
			}else if(BMi>40){
				System.out.println("massive Adipositas");
			}
		}else if(MoW.equals("m")){
			if(BMi<20){
				System.out.println("Untergewicht");
			}else if(BMi>20&&BMi<25){
				System.out.println("Normalgewicht");
			}else if(BMi>25&&BMi<30){
				System.out.println("Übergewicht");
			}else if(BMi>30&&BMi<40){
				System.out.println("Adipositas(Fettleibigkeit)");
			}else if(BMi>40){
				System.out.println("massive Adipositas");
			}
		}
	}
}
