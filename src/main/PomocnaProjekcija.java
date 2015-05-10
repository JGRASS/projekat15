package main;

public class PomocnaProjekcija {

	private String nazivFilma;

	private String sala;
	
	private int vreme;
	
	public String getNazivFilma() {
		return nazivFilma;
	}

	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getVreme() {
		return vreme;
	}

	public void setVreme(int vreme) {
		this.vreme = vreme;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PomocnaProjekcija)) {
			return false;
		}
		
		PomocnaProjekcija pom = (PomocnaProjekcija)obj;
		
			if(pom.getSala().equals(sala) && pom.getVreme() == vreme) {
				return true;
			} 
		
		return false;
	}

}
