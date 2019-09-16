package Praktikumsorganisation;

import java.util.LinkedList;

public class Praktikum {

	private String bezeichnung;
	private boolean istGestartet;
	LinkedList<Student> student; 
	LinkedList<Lehrkraft> lehrkraft; 
	
	public Praktikum() {
		// TODO Auto-generated constructor stub
		
		student = new LinkedList<Student>();
		lehrkraft = new LinkedList<Lehrkraft>();
	}

	public int hinzufuegen(Student s){
		
	}
	
	public boolean hinzufuegen(Lehrkraft l){
		
	}
	
	public Student entfernen(String n){
		
	}
	
	public Student sucheStudent(String name){
		
	}
	
	public double ermittleDurchschnittsnote(){
		
	}
	
	public double ermittleDurchschnittssemester(){
		
	}
	
	public String filter(double d, int s ){
		
	}
}
