package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordenadaTest {

	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		
		coordenada = new Coordenada(2, 3);
		
	}
	
	@Test
	void test001_UnaCoordenadaConoceSuX() {
		
		assertEquals(coordenada.getX(), 2);
		
	}
	
	@Test
	void test002_UnaCoordenadaConoceSuY() {
		
		assertEquals(coordenada.getY(), 3);
		
	}

}
