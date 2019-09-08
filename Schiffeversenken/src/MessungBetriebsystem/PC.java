package MessungBetriebsystem;

public class PC {

	private int hddkapa;
	private String hddname;
	private String proname;
	private int prio;
	private boolean b;
	private boolean l;
	
	private BS bs;
	private PCGUI gui;
	public PC(BS bs,PCGUI gui) {
		// TODO Auto-generated constructor stub
//		bs.hinzufuegen(new HDD("Test",100));
//		System.out.println(bs.toStringHDDs());
//		System.out.println(bs.toStringProzesse());
//		System.out.println(bs.toString());
//		System.out.println("GesamtSpeicher: "+bs.brerechneGesamtkazitaet());
//		bs.tauscheHDD('C', new HDD("Intenso3",500));
//		System.out.println(bs.toStringHDDs());
//		bs.entferneHDD('C');
//		bs.hinzufuegen(new HDD("Test2",10000));
//		gui.addLabel();
//		System.out.println(bs.toStringHDDs());
		this.bs = bs;
		this.gui = gui;
	}
	
	public void addhdd() {
		bs.hinzufuegen(new HDD(hddname,hddkapa));
		gui.addLabel();
	}
	public void addpro(){
		bs.hinzufuegen(new Prozess(proname,l,b,prio));
		gui.addPro();
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public boolean isL() {
		return l;
	}

	public void setL(boolean l) {
		this.l = l;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public int getPrio() {
		return prio;
	}

	public void setPrio(int prio) {
		this.prio = prio;
	}

	public int getHddkapa() {
		return hddkapa;
	}


	public void setHddkapa(int hddkapa) {
		this.hddkapa = hddkapa;
	}


	public String getHddname() {
		return hddname;
	}


	public void setHddname(String hddname) {
		this.hddname = hddname;
	}
}
