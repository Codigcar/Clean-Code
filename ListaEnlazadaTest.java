import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ListaEnlazadaTest {

	private static ListaEnlazada lista;
	
	// Para instanciar
	@BeforeAll
	static void init() {
		lista = new ListaEnlazada();
	}
	
	@Test
	void test() {
		int expected = 2000;
		int[] arregloBase = Helper.generarArrayAleatorio(expected);
		int actual = lista.crearSimple(arregloBase);
		
		assertEquals(expected, actual);
	}

}
