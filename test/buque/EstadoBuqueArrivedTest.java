package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;

class EstadoBuqueArrivedTest {

	EstadoBuque arrived;
	Buque buque;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		arrived= new Arrived();
		coordenada = mock(Coordenada.class);
		buque = new Buque("Titanic", coordenada);
	}

	@Test
	void test001_NoSePuedePasarDelEstadoArrivedAlEstadoOutBound() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoOutOfBound(buque));
		
	}
	
	@Test
	void test002_NoSePuedePasarDelEstadoArrivedAlEstadoInBound() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoInBound(buque));
		
	}
	
	@Test
	void test003_NoSePuedePasarDelEstadoArrivedAlEstadoArrived() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test004_SePuedePasarDelEstadoArrivedAlEstadoWorking() {
		
		buque.setEstado(arrived);
		
		arrived.pasarAEstadoWorking(buque);
		
		assertInstanceOf(Working.class, buque.getEstado());
		
	}
	
	@Test
	void test005_NoSePuedePasarDelEstadoArrivedAlEstadoDeparting() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoDeparting(buque));
		
	}

}
