package MessungBetriebsystem;

public class PC {

	private static BS bs = new BS("Windows",1,0,new Prozess("Java",true,true,3),"Intenso",1000.0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bs.hinzufuegen(new HDD("Test",100));
		System.out.println(bs.toStringHDDs());
		System.out.println(bs.toStringProzesse());
		System.out.println(bs.toString());
		System.out.println("GesamtSpeicher: "+bs.brerechneGesamtkazitaet());
		bs.tauscheHDD('C', new HDD("Intenso3",500));
		System.out.println(bs.toStringHDDs());
		bs.entferneHDD('C');
		bs.hinzufuegen(new HDD("Test2",10000));
		System.out.println(bs.toStringHDDs());
		
	}

}
