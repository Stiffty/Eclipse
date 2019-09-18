package Praktikumsorganisation;

import java.util.Iterator;
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
		student.add(s);
		return student.size();
	}
	
	public boolean hinzufuegen(Lehrkraft l){
		if(lehrkraft.size()>= 3){
			return false;
		}else{
			lehrkraft.add(l);
			return true;
		}
	}
	
	public void entfernen(String n){
		 for (int i = 0; i < student.size(); i++) {
			if(student.get(i).equals(n)){
				student.remove(i);
			}
		}
	}
	
	public Student sucheStudent(String name){
		for (int i = 0; i < student.size(); i++) {
			if(student.get(i).equals(name)){
				
				return student.get(i);
			}
		}
		 return null;
	}
	
	public double ermittleDurchschnittsnote(){
		int summeNoten = 0;
		for (int i = 0; i < student.size(); i++) {
			summeNoten += student.get(i).getDurchschnitt();
		}
		
		return summeNoten/student.size();
	}
	
	public double ermittleDurchschnittssemester(){
		int summeSemester = 0;
		for (int i = 0; i < student.size(); i++) {
			summeSemester += student.get(i).getSemester();
		}
		
		return summeSemester/student.size();
	}
	
	public String filter(double d, int s ){
		String rueckgabe = new String();
		if(student.size() == 0){
			return "Keine Teilnehmer";
		}else{
			for (int i = 0; i < student.size(); i++) {
				if(student.get(i).getDurchschnitt()> d){
					rueckgabe += student.get(i).toString() + "\n";
				}
				if(student.get(i).getDurchschnitt()> s){
					rueckgabe += student.get(i).toString() + "\n";
				}
			}
			if(rueckgabe == new String()){
				return "Keine Studenten gefunden.";
			}else{
				return rueckgabe;
			}
		}
	}
	
	public boolean start (){
		
	}
	
	public String sortiren (){
		
	}
	
	public String toStringStudent(){
		
	}
	
	public String toStringLehrkraefte(){
		
	}

	@Override
	public String toString() {
		return "Praktikum [bezeichnung=" + bezeichnung + ", istGestartet=" + istGestartet + ", student=" + student
				+ ", lehrkraft=" + lehrkraft + "]";
	}
	
	
}
