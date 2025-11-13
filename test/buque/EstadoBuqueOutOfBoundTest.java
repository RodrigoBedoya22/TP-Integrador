package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;

class EstadoBuqueOutOfBoundTest {
	
	EstadoBuque outOfBound;
	Buque buque;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		outOfBound= new OutOfBound();
		coordenada = mock(Coordenada.class);
		buque = new Buque("Titanic", coordenada);
	}

	@Test
	void test001_NoSePuedePasarDeEstadoOutBoundAlEstadoOutBound() {
		
		assertThrows(IllegalStateException.class, () -> outOfBound.pasarAEstadoOutOfBound(buque));
		
	}
	@Test
	void test002_SePuedePasarDelEstadoOutBoundAlEstadoInBound() {
		
		outOfBound.pasarAEstadoInBound(buque);
		
		assertInstanceOf(InBound.class, buque.getEstado());
	}
	
	@Test
	void test003_NoSePuedePasarDeEstadoOutBoundAlEstadoArrived() {
		
		assertThrows(IllegalStateException.class, () -> outOfBound.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test004_NoSePuedePasarDeEstadoOutBoundAlEstadoWorking() {
		
		assertThrows(IllegalStateException.class, () -> outOfBound.pasarAEstadoWorking(buque));
		
	}
	
	@Test
	void test005_NoSePuedePasarDeEstadoOutBoundAlEstadoDeparting() {
		
		assertThrows(IllegalStateException.class, () -> outOfBound.pasarAEstadoDeparting(buque));
		
	}

}
