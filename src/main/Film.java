package main;

public class Film {

	private String nazivFilma;
	private String reziser;
	private String zanr;
	private String ocena;

	@Override
	public String toString() {
		return "Film [nazivFilma=" + nazivFilma + ", reziser=" + reziser
				+ ", zanr=" + zanr + ", ocena=" + ocena + "]";
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
