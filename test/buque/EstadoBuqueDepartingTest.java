package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coordenada.Coordenada;

class EstadoBuqueDepartingTest {

	EstadoBuque departing;
	Buque buque;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		departing = new Departing();
		
		coordenada = mock(Coordenada.class);
		buque = new Buque("pepe", coordenada);
	}
	
	@Test
	void test001_SePuedePasarDelEstadoDepartingAlEstadoOutBound() {
		
		buque.setEstado(departing);
		
		departing.pasarAEstadoOutOfBound(buque);
		
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	
	@Test
	void test002_NoSePuedePasarDelEstadoDepartingAlEstadoInBound() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoInBound(buque));
		
	}
	
	@Test
	void test003_NoSePuedePasarDelEstadoDepartingAlEstadoArrived() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test004_NoSePuedePasarDelEstadoDepartingAlEstadoWorking() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoWorking(buque));
		
	}
	
	@Test
	void test005_NoSePuedePasarDelEstadoDepartingAlEstadoDeparting() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoDeparting(buque));
		
	}
	
}
