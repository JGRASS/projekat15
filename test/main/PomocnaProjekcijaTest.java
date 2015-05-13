package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PomocnaProjekcijaTest {

	PomocnaProjekcija pp;
	
	@Before
	public void setUp() throws Exception {
		
		pp = new PomocnaProjekcija();
	}

	@After
	public void tearDown() throws Exception {
		pp = null;
	}
	
	@Test
	public void testSetNazivFilma() {
		pp.setNazivFilma("Vruca potera");
		assertEquals("Vruca potera", pp.getNazivFilma());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivFilmaNull() {
		pp.setNazivFilma(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivFilmaPrazanString() {
		pp.setNazivFilma("");
	}
	
	@Test
	public void testSetSala() {
		pp.setSala("Sala 1");
		assertEquals("Sala 1", pp.getSala());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSalaNull() {
		pp.setSala(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSalaPrazanString() {
		pp.setSala("");
	}

	@Test
	public void testSetVreme() {
		pp.setVreme("18:00");
		assertEquals("18:00",pp.getVreme());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVremeNull() {
		pp.setVreme(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVremePrazanString() {
		pp.setVreme("");
	}

}



