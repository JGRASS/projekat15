package main;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClanTest {
	
	Clan cl;

	@Before
	public void setUp() throws Exception {
		cl = new Clan();
	}

	@After
	public void tearDown() throws Exception {
		cl = null;
	}

	@Test
	public void testSetImeIPrezime() {
		cl.setImeIPrezime("Mina Marjanovic");
		assertEquals("Mina Marjanovic", cl.getImeIPrezime());
	}

	@Test
	public void testSetID() {
		cl.setID(2);
		assertEquals(2, cl.getID());
	}

	@Test
	public void testSetRezervacije() {
		LinkedList<PomocnaProjekcija> rezerv = new LinkedList<>();
		assertEquals(rezerv, cl.getRezervacije());
	}

}
