package main;

import java.util.GregorianCalendar;

public class Projekcija {
	/**
	 * film tipa Film
	 */
	Film film;
	/**
	 * sala
	 */
	Sala sala;
	/**
	 * datum i vreme tipa GregorianCalendar
	 */
	GregorianCalendar datumIVreme;
	
	@Override
	public String toString() {
		return "Projekcija [film=" + film.getNazivFilma() + ", sala=" + sala.getID() + ", datumIVreme="
				+ datumIVreme + "]";
	}
	/**
	 * metoda koja vraca film tipa Film
	 * @return film tipa Film
	 */
	public Film getFilm() {
		return film;
	}
	/**
	 * metoda koja postavlja vrednost filma na unetu vrednost
	 * @param film kao Film
	 */
	public void setFilm(Film film) {
		this.film = film;
	}
	/**
	 * metoda koja vraca salu 
	 * @return sala kao Sala
	 */
	public Sala getSala() {
		return sala;
	}
	/**
	 * metoda koja postavlja vrednost sale na unetu vrednost
	 * @param sala kao Sala
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	/**
	 * metoda koja vraca datum i vreme
	 * @return datum i vreme kao GregorianCalendar
	 */
	public GregorianCalendar getDatumIVreme() {
		return datumIVreme;
	}
	/**
	 * metoda koja postavlja vrednost datuma i vremena na unetu
	 * @param datumIVreme kao GregorianCalendar
	 */
	public void setDatumIVreme(GregorianCalendar datumIVreme) {
		this.datumIVreme = datumIVreme;
	}
}
