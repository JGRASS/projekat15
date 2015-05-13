package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmTest {

	Film filmic;
	
	@Before
	public void setUp() throws Exception {
		filmic = new Film();
	}

	@After
	public void tearDown() throws Exception {
		filmic = null;
	}

	@Test
	public void testSetOpis() {
		filmic.setOpis("Nezaboravna komedija s neodoljivom Sofijom Vergarom i dobitnicom Oskara Ris Viderspun!");
		assertEquals("Nezaboravna komedija s neodoljivom Sofijom Vergarom i dobitnicom Oskara Ris Viderspun!", filmic.getOpis());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetOpisNull() {
		filmic.setOpis(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetOpisPrazanString() {
		filmic.setOpis("");
	}

	@Test
	public void testSetAdresaSlike() { 
		filmic.setAdresaSlike("/posteri/a.jpg");
		assertEquals("/posteri/a.jpg", filmic.getAdresaSlike());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAdresaSlikeNull() {
		filmic.setAdresaSlike(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAdresaSlikePrazanString() {
		filmic.setAdresaSlike("");
	}

	@Test
	public void testSetNazivFilma() {
		filmic.setNazivFilma("Vruca potera");
		assertEquals("Vruca potera",filmic.getNazivFilma());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivFilmaNull() {
		filmic.setNazivFilma(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivFilmaPrazanString() {
		filmic.setNazivFilma("");
	}

	@Test
	public void testSetReziser() {
		filmic.setReziser("Anne Fletcher");
		assertEquals("Anne Fletcher",filmic.getReziser());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetReziserNull() {
		filmic.setReziser(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetReziserPrazanString() {
		filmic.setReziser("");
	}

	@Test
	public void testSetZanr() {
		filmic.setZanr("komedija");
		assertEquals("komedija",filmic.getZanr());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetZanrNull() {
		filmic.setZanr(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetZanrPrazanString() {
		filmic.setZanr("");
	}

	@Test
	public void testSetOcena() {
		filmic.setOcena("8.9");
		assertEquals("8.9",filmic.getOcena());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testOcenaNull() {
		filmic.setOcena(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetOcenaPrazanString() {
		filmic.setOcena("");
	}

}
