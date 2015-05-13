package sistemskeoperacije;

import static org.junit.Assert.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SOUcitajIzFajlaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("data/Lista_filmova.txt"));
			String pom = in.readLine();
			assertEquals("OSVETNICI - ERA ALTRONA;Joss Whedon;akcija, avantura;Studio Marvel predstavlja „Osvetnici – Era Altrona“, epski nastavak najuspešnijeg filma o superherojima svih vremena.;8.1;/posteri/a.jpg;", pom);
			in.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}}
