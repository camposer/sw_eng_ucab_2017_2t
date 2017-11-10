package pruebas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HolaMundoTest {
	private HolaMundo holaMundo;
	
	@Before
	public void beforeEach() {
		holaMundo = new HolaMundo();
	}
	
	@Test
	public void saludarSucceful() {
		String actual = 
				holaMundo.saludar("Rodolfo");
		String expected = "Hola Rodolfo";
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void saludarError() {
		String actual = 
				new HolaMundo().saludar("Rodolfo");
		String expected = "Hello Rodolfo";
		
		Assert.assertNotEquals(expected, actual);
	}
}

class HolaMundo {
	public String saludar(String nombre) {
		return "Hola " + nombre + "!";
	}
}

