package main;

import java.util.GregorianCalendar;

public class Projekcija {
	
	Film film;
	Sala sala;
	GregorianCalendar datumIVreme;
	
	@Override
	public String toString() {
		return "Projekcija [film=" + film.getNazivFilma() + ", sala=" + sala.getID() + ", datumIVreme="
				+ datumIVreme + "]";
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public GregorianCalendar getDatumIVreme() {
		return datumIVreme;
	}
	public void setDatumIVreme(GregorianCalendar datumIVreme) {
		this.datumIVreme = datumIVreme;
	}
}
