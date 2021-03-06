package sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import main.PomocnaProjekcija;

public class SOSerialize {
	/**
	 * Metoda koja serijalizuje listu objekata tipa pomocna projekcija.
	 * @param LinkedList<PomocnaProjekcija>
	 * @throws IOException
	 */
	
	public static void serialize(LinkedList<PomocnaProjekcija> lista){
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/serialize.out")));
			
			for (int i = 0; i < lista.size(); i++) {
				out.writeObject(lista.get(i));
			}
			
			out.close();
		} catch (IOException e) {
		System.out.println("sshit happens "+e);
		}
	}

}
