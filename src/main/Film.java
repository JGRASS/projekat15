package main;

public class Film {
	/**
	 * Naziv filma.
	 */
	private String nazivFilma;
	/**
	 * Reziser filma.
	 */
	private String reziser;
	/**
	 * Zanr filma.
	 */
	private String zanr;
	/**
	 * Kako su gledaoci ocenili film.
	 */
	private String ocena;
	/**
	 * Adresa na kojoj se nalazi plakat za film.
	 */
	private String adresaSlike;
	/**
	 * Opis filma.
	 */
	private String opis;
	/**
	 * Metoda koja vraca vrednost atributa opis.
	 * @return opis kao String
	 */
	public String getOpis() {
		return opis;
	}
	/**
	 * Metoda postavlja vrednost atributa opis na unetu vrednost.
	 * @param opis Nova vrednost za atribut opis.
	 */
	public void setOpis(String opis) {
		if( opis == null || opis.isEmpty()) {
			throw new RuntimeException("Opis ne sme biti null ili prazan String");
		}
		this.opis = opis;
	}
	/**
	 * Metoda koja vraca vrednost atributa adresaSlike.
	 * @return adresaSlike kao String
	 */
	public String getAdresaSlike() {
		return adresaSlike;
	}
	/**
	 * Metoda postavlja vrednost atributa adresaSlike na unetu vrednost.
	 * @param adresaSlike Nova vrednost za atribut adresaSlike.
	 */
	public void setAdresaSlike(String adresaSlike) {
		if(adresaSlike == null || adresaSlike.isEmpty()) {
			throw new RuntimeException("Ne sme biti null ili prazan String");
		}
		this.adresaSlike = adresaSlike;
	}
	/**
	 * Metoda koja pravi string od objekta tipa Film.
	 * @return Film kao String
	 */
	@Override
	public String toString() {
		return nazivFilma;
	}
	/**
	 * Metoda koja vraca vrednost atributa nazivFilma.
	 * @return nazivFilma kao String
	 */
	public String getNazivFilma() {
		return nazivFilma;
	}
	/**
	 * Metoda postavlja vrednost atributa nazivFilma na unetu vrednost.
	 * @param nazivFilma Nova vrednost za atribut nazivFilma.
	 */
	public void setNazivFilma(String nazivFilma) {
		if( nazivFilma == null || nazivFilma.isEmpty()) {
			throw new RuntimeException("Naziv filma ne sme biti null ili prazan String");
		}
		this.nazivFilma = nazivFilma;
	}
	/**
	 * Metoda koja vraca vrednost atributa reziser.
	 * @return reziser kao String
	 */
	public String getReziser() {
		return reziser;
	}
	/**
	 * Metoda postavlja vrednost atributa reziser na unetu vrednost.
	 * @param reziser Nova vrednost za atribut reziser.
	 */
	public void setReziser(String reziser) {
		if( reziser == null || reziser.isEmpty()) {
			throw new RuntimeException("Ime rezisera ne sme biti null ili prazan String");
		}
		this.reziser = reziser;
	}
	/**
	 * Metoda koja vraca vrednost atributa zanr.
	 * @return zanr kao String
	 */
	public String getZanr() {
		return zanr;
	}
	/**
	 * Metoda postavlja vrednost atributa zanr na unetu vrednost.
	 * @param zanr Nova vrednost za atribut zanr.
	 */
	public void setZanr(String zanr) {
		if( zanr == null || zanr.isEmpty()) {
			throw new RuntimeException("Zanr ne sme biti null ili prazan String");
		}
		this.zanr = zanr;
	}
	/**
	 * Metoda koja vraca vrednost atributa ocena.
	 * @return ocena kao String
	 */
	public String getOcena() {
		return ocena;
	}
	/**
	 * Metoda postavlja vrednost atributa ocena na unetu vrednost.
	 * @param ocena Nova vrednost za atribut ocena.
	 */
	public void setOcena(String ocena) {
		if( ocena == null || ocena.isEmpty()) {
			throw new RuntimeException("ne sme biti null ili prazan String");
		}
		this.ocena = ocena;
	}
}
