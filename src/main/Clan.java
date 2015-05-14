package main;

import java.util.LinkedList;

public class Clan {
	/**
	 * ime i prezime
	 */
	private String imeIPrezime;
	/**
	 * ID clana
	 */
	private int ID;
	/**
	 * lista rezervacija 
	 */
	private LinkedList<PomocnaProjekcija> rezervacije = new LinkedList<>();
	/**
	 * metoda koja vraca ime i prezime
	 * @return ime i prezime kao String
	 */
	public String getImeIPrezime() {
		return imeIPrezime;
	}
	/**
	 * metoda koja postavlja vrednost atributa na unetu vrednost
	 * @param imeIPrezime kao String
	 */
	public void setImeIPrezime(String imeIPrezime) {
		if(imeIPrezime == null || imeIPrezime.isEmpty()) {
			throw new RuntimeException("Ime i prezime ne sme biti null ili prazan String.");
		}
		this.imeIPrezime = imeIPrezime;
	}
	/**
	 * metoda koja vraca ID kao int
	 * @return ID kao int
	 */
	public int getID() {
		return ID;
	}
	/**
	 * metoda koja postavlja vrednost atributa ID na unetu vrednost
	 * @param iD kao int
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * metoda koja vraca listu rezervacija
	 * @return listu rezervacija tipa Film 
	 */
	public LinkedList<PomocnaProjekcija> getRezervacije() {
		return rezervacije;
	}
	/**
	 * metoda koja postavlja vrednost atributa lista na unetu vrednost
	 * @param rezervacije kao LinkedList<Film>
	 */
	public void setRezervacije(LinkedList<PomocnaProjekcija> rezervacije) {
		if(rezervacije.isEmpty()) {
			throw new RuntimeException("Lista ne sme biti prazna.");
		}
		this.rezervacije = rezervacije;
	}
}
