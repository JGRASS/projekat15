package main;

public class Film {

	private String nazivFilma;
	private String reziser;
	private String zanr;
	private String ocena;
	private String adresaSlike;
	private String opis;

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getAdresaSlike() {
		return adresaSlike;
	}

	public void setAdresaSlike(String adresaSlike) {
		this.adresaSlike = adresaSlike;
	}

	@Override
	public String toString() {
		return nazivFilma;
	}

	public String getNazivFilma() {
		return nazivFilma;
	}

	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
	}

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getOcena() {
		return ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}
}
