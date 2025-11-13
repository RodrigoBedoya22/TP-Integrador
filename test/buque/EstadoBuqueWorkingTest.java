package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;

class EstadoBuqueWorkingTest {

	EstadoBuque working;
	Buque buque;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		working = new Working();
		
		coordenada = mock(Coordenada.class);
		buque = new Buque("pepe", coordenada);
	}
	
	//-------------TEST DE ESTADO WORKING-------------------------
	@Test
	void test001_NoSePuedePasarDelEstadoWorkingAlEstadoOutBound() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoOutOfBound(buque));
		
	}
	
	@Test
	void test002_NoSePuedePasarDelEstadoWorkingAlEstadoInBound() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoInBound(buque));
		
	}
	
	@Test
	void test003_NoSePuedePasarDelEstadoWorkingAlEstadoArrived() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test004_NoSePuedePasarDelEstadoWorkingAlEstadoWorking() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoWorking(buque));
		
	}
	
	@Test
	void test005_SePuedePasarDelEstadoWorkingAlEstadoDeparting() {
		
		buque.setEstado(working);
		
		working.pasarAEstadoDeparting(buque);
		
		assertInstanceOf(Departing.class, buque.getEstado());
		
	}

}
