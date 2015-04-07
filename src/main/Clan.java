package main;

import java.util.LinkedList;

public class Clan {
	private String imeIPrezime;
	private int ID;
	private LinkedList<Film> rezervacije = new LinkedList<>();
	
	public String getImeIPrezime() {
		return imeIPrezime;
	}
	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public LinkedList<Film> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(LinkedList<Film> rezervacije) {
		this.rezervacije = rezervacije;
	}
}
