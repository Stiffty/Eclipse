package Praktikumsorganisation;

import java.util.LinkedList;
import java.util.List;

public class Student {

	private String name;
	private double durchschnitt;
	private int semester;
	private int matrikelnummer;
	private static int zaehler = 0;
	
	private List<Praktikum> praktika;
	
	
	public Student(String name, double durchschnitt, int semester) {
		this.name = name;
		this.durchschnitt = durchschnitt;
		this.semester = semester;
		
		praktika = new LinkedList<Praktikum>();
		
		matrikelnummer = 1234567 + zaehler;
		zaehler++;
	}
	
	@Override
	public String toString() {
		return name +" (" + durchschnitt + ", " + semester + ")";
	}
	public String toStringPraktika (){
		return "Aktuelle Praktika von " + name +
				"(Semester: " + semester + ")" ;
				
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDurchschnitt() {
		return durchschnitt;
	}

	public void setDurchschnitt(double durchschnitt) {
		this.durchschnitt = durchschnitt;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	

}
