package gui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import main.PomocnaProjekcija;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GUIKontrolerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRezervacije() {
		RezervacijeGUI rezervacije = new RezervacijeGUI();
		PomocnaProjekcija pom = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/serialize.out"));
			pom = (PomocnaProjekcija)in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(pom, rezervacije.lista.getFirst());
	}
	

}
