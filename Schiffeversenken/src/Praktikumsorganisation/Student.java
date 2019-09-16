package Praktikumsorganisation;

public class Student {

	private String name;
	private double durchschnitt;
	private int semester;
	
	
	public Student(String name, double durchschnitt, int semester) {
		this.name = name;
		this.durchschnitt = durchschnitt;
		this.semester = semester;
	}
	
	@Override
	public String toString() {
		return name +" (" + durchschnitt + ", " + semester + ")";
	}
	public String toStringPraktika (){
		return "Aktuelle Praktika von " + name +
				"(Semester: " + semester + ")" ;
				
	}

}
