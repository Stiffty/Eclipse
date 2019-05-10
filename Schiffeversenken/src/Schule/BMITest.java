package Schule;

public class BMITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double BMI1;
		BMI BMI = new BMI();
		
		BMI.größe(1.85);
		BMI.gewicht(84);
		BMI1 = BMI.BMIBer();
		BMI.auswertung("m");
	}

}
