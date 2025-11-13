package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;

class EstadoBuqueInBoundTest {

	EstadoBuque inBound;
	Buque buque;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		inBound= new InBound();
		coordenada = mock(Coordenada.class);
		buque = new Buque("Titanic", coordenada);
	}

	@Test
	void test001_SePuedePasarDeEstadoInBoundAlEstadoOutBound() {
		buque.setEstado(inBound);
		
		inBound.pasarAEstadoOutOfBound(buque);
		
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	//*
	@Test
	void test002_NoSePuedePasarDeEstadoInBoundAlEstadoInBound() {
		
		buque.setEstado(inBound);
		
		assertThrows(IllegalStateException.class, () -> inBound.pasarAEstadoInBound(buque));
	}
	
	@Test
	void test003_SePuedePasarDeEstadoInBoundAlEstadoArrived() {
		
		buque.setEstado(inBound);
		
		inBound.pasarAEstadoArrived(buque);
		
		assertInstanceOf(Arrived.class, buque.getEstado());
		
	}
	
	@Test
	void test004_NoSePuedePasarDeEstadoInBoundAlEstadoWorking() {
		
		buque.setEstado(inBound);
		
		assertThrows(IllegalStateException.class, () -> inBound.pasarAEstadoWorking(buque));
	}
	
	@Test
	void test005_NoSePuedePasarDeEstadoInBoundAlEstadoDeparting() {
		
		buque.setEstado(inBound);
		
		assertThrows(IllegalStateException.class, () -> inBound.pasarAEstadoDeparting(buque));
	}
}
