package FirmaSoftVererbung;

import java.util.LinkedList;
import java.util.List;

public class firma {

	private String firmenname;
	private List <person> personen;
	
	public firma(String firmenname) {
		// TODO Auto-generated constructor stub
		this.firmenname = firmenname;
		personen = new LinkedList<person>();
	}
	public boolean hinzufuegen(person p){
		personen.add(p);
		return true;
	}
	public boolean entfernen(person p){
		for (int i = 0; i < personen.size();i++) {
			if(personen.get(i)== p){
				personen.remove(i);
				return true;
			}
		}
		return false;
	}
	public person suche(person p){
		for (int i = 0; i < personen.size();i++) {
			if(personen.get(i)== p){
		
				return personen.get(i);
			}
		}
		return null;
	}
	public String getFirmenname() {
		return firmenname;
	}
	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}
	public List<person> getPersonen() {
		return personen;
	}
	public void setPersonen(List<person> personen) {
		this.personen = personen;
	}
}
