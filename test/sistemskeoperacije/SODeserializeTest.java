package sistemskeoperacije;

import static org.junit.Assert.*;


import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import main.PomocnaProjekcija;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SODeserializeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		PomocnaProjekcija pom = new PomocnaProjekcija();
		
		pom.setNazivFilma("test naziv");
		pom.setSala("test sala");
		pom.setVreme("test vreme");
		LinkedList<PomocnaProjekcija> lista = new LinkedList<>();
		lista.add(pom);
		SOSerialize.serialize(lista);
		assertEquals(pom, SODeserialize.deserialize().getLast());
	}}


