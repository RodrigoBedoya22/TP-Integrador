package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;

class BuqueTest {
	Buque buque;
	
	@BeforeEach
	void setUp() throws Exception {
		Coordenada coordenada = new Coordenada(1.0,2.0);
		buque= new Buque("Titanic", coordenada);
	}

	@Test
	void test001_UnBuqueConoceSuNombre() {
		
		assertEquals(buque.getNombre(), "Titanic");
	}
	
	@Test
	void test002_UnBuqueConoceSuCoordenada() {
		
		assertEquals(buque.getCoordenada().getX(), 1.0);
		assertEquals(buque.getCoordenada().getY(), 2.0);
	}
	
	
	
}
