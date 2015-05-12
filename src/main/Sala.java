package main;

public class Sala {
	/**
	 * Identifikacioni broj sale.
	 */
	private int ID;
	/**
	 * Broj ljudi koji mogu da stanu u salu.
	 */
	private int kapacitet;
	/**
	 * Matrica sedista u sali.
	 */
	private boolean[][] sedista;
	/**
	 * Metoda koja vraca vrednost atributa ID.
	 * @return ID kao int
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Metoda postavlja vrednost atributa ID na unetu vrednost.
	 * @param ID Nova vrednost za atribut ID.
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Metoda koja vraca vrednost atributa kapacitet.
	 * @return Kapacitet kao int
	 */
	public int getKapacitet() {
		return kapacitet;
	}
	/**
	 * Metoda postavlja vrednost atributa kapacitet na unetu vrednost.
	 * @param kapacitet Nova vrednost za atribut kapacitet.
	 */
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	/**
	 * Metoda koja vraca vrednost atributa sedista.
	 * @return sedista kao boolean matrica
	 */
	public boolean[][] getSedista() {
		return sedista;
	}
	/**
	 * Metoda postavlja vrednost atributa sedista na unetu vrednost.
	 * @param sedista Nova vrednost za atribut sedista.
	 */
	public void setSedista(boolean[][] sedista) {
		this.sedista = sedista;
	}

}
