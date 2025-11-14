package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coordenada.Coordenada;

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
	
	@Test
	void test003_UnaCoordenadaConoceLaDistanciaHaciaOtraCoordenada() {
		//DOC
		Coordenada coordenadaDOC = new Coordenada(11.0, 22.0);
		
		assertEquals(coordenada.distanciaHaciaCoordenada(coordenadaDOC), 21.02);
	}

}
