package MessungBetriebsystem;

public class Prozess {

	private String name;
	private boolean laufend;
	private boolean bereit;
	private int prio;
	
	public Prozess(String n,boolean b) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.bereit = b;
	}
	public Prozess(String n,boolean l,boolean b,int p) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.laufend = l;
		this.bereit = b;
		this.prio = p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLaufend() {
		return laufend;
	}
	public void setLaufend(boolean laufend) {
		this.laufend = laufend;
	}
	public boolean isBereit() {
		return bereit;
	}
	public void setBereit(boolean bereit) {
		this.bereit = bereit;
	}
	public int getPrio() {
		return prio;
	}
	public void setPrio(int prio) {
		this.prio = prio;
	}

}
