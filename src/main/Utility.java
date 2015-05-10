package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Utility {

	
	public static LinkedList<Film> ucitajIzFajla(){
		LinkedList<Film> lista = new LinkedList<>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("data/Lista_filmova.txt"));
			boolean kraj = false;
			while(!kraj){
				String pom = in.readLine();
				if(pom == null) {
					kraj=true;
					continue;
				}
				String[] podaci = pom.split(";");
				Film film = new Film();
				film.setNazivFilma(podaci[0]);
				film.setReziser(podaci[1]);
				film.setZanr(podaci[2]);
				film.setOcena(podaci[3]);
				film.setAdresaSlike(podaci[4]);
				lista.add(film);
			}
			
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
