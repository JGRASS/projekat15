package main;

public class Sala {

	private int ID;
	private int kapacitet;
	private boolean[][] sedista;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public boolean[][] getSedista() {
		return sedista;
	}

	public void setSedista(boolean[][] sedista) {
		this.sedista = sedista;
	}

}
