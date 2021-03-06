package main;

import java.io.Serializable;


public class PomocnaProjekcija implements Serializable{


	/**
	 * naziv filma
	 */
	private String nazivFilma;

	/**
	 * sala u kojoj se daje film
	 */
	private String sala;
	
	/**
	 * vreme pocetka filma
	 */
	private String vreme;     
	
	/**
	 * metoda koja vraca naziv filma
	 * @return naziv filma kao String
	 */
	public String getNazivFilma() {
		return nazivFilma;
	}

	/**
	 * postavlja vrednost atributa naziv filma na unetu vrednost
	 * @param nazivFilma kao String
	 * @throws java.lang.RuntimeException
	 * <ul>
	 *<li>unet naslov null</li>
	 *	<li>ili prazan String</li>
	 *</ul>
	 */
	public void setNazivFilma(String nazivFilma) {
		if(nazivFilma == null || nazivFilma.isEmpty()) {
			throw new RuntimeException("Naslov ne sme biti null ili prazan String.");
		}
		this.nazivFilma = nazivFilma;
	}
	/**
	 * metoda koja vraca salu
	 * @return sala kao String
	 */
	public String getSala() {
		return sala;
	}

	/**
	 * postavlja vrednost atributa sala na unetu vrednost
	 * @param sala kao String
	 * @throws java.lang.RuntimeException
	 * <ul>
	 *<li>uneta sala null</li>
	 *	<li>ili prazan String</li>
	 *</ul>
	 */
	public void setSala(String sala) {
		if(sala == null || sala.isEmpty()) {
			throw new RuntimeException("Sala ne sme biti null ili prazan String.");
		}
		this.sala = sala;
	}

	/**
	 * metoda koja vraca vreme u casovima
	 * @return vreme kao String
	 */
	public String getVreme() {
		return vreme;
	}

	/**
	 *  postavlja vrednost atributa vreme na unetu vrednost
	 * @param vreme kao String
	 * @throws java.lang.RuntimeException
	 * <ul>
	 *<li>uneto vreme null</li>
	 *<li>prazan string</li>
	 *</ul>
	 */
	public void setVreme(String vreme) {
		if(vreme.equals(null) || vreme.isEmpty()) {
			throw new RuntimeException("Vreme ne sme biti null ili prazan String"); 
		}
		this.vreme = vreme;
	}
	

	public boolean equals(Object obj) {
		if(!(obj instanceof PomocnaProjekcija)) {
			return false;
		}
		
		PomocnaProjekcija pom = (PomocnaProjekcija)obj;
		
			if(pom.getSala().equals(sala) && pom.getVreme().equals(vreme)) {
				return true;
			} 
		
		return false;
	}
	
	/**
	 * Metoda toString 
	 * @return naziv filma, sala i vreme projekcije
	 */
	public String toString() {
		return "PomocnaProjekcija [nazivFilma=" + nazivFilma + ", sala=" + sala
				+ ", vreme=" + vreme + "]";
	}

}
