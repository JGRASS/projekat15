package sistemskeoperacije;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import main.PomocnaProjekcija;

public class SODeserialize {

	
	public static LinkedList<PomocnaProjekcija> deserialize(){
		LinkedList<PomocnaProjekcija> lista = new LinkedList<>();
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/serialize.out"));
			
			try {
				while(true){
					PomocnaProjekcija pom = (PomocnaProjekcija) in.readObject();
				
					lista.add(pom);
					
				}
				
			} catch (EOFException | ClassNotFoundException e) {
				
			}
		} catch (IOException e) {
			
		}
		
		return lista;
	}
}
