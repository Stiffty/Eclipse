package Praktikumsorganisation;

public class Lehrkraft {

	private String name;
	private String fachbereich;
	private boolean isProfessor;
	
	public Lehrkraft(String n,String f,boolean i) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.fachbereich = f;
		this.isProfessor = i;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFachbereich() {
		return fachbereich;
	}
	public void setFachbereich(String fachbereich) {
		this.fachbereich = fachbereich;
	}
	public boolean isProfessor() {
		return isProfessor;
	}
	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}

}
