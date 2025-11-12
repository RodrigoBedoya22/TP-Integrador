package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;

class EstadoBuqueTest {

	EstadoBuque outOfBound, inBound, arrived, working,departing;
	Buque buque;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		
		outOfBound = new OutOfBound();
		inBound = new InBound();
		arrived = new Arrived();
		working = new Working();
		departing = new Departing();
		
		coordenada = mock(Coordenada.class);
		buque = new Buque("pepe", coordenada);
	}
	
	//-------------TEST DE ESTADO OUT BOUND-------------------------
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
	//-------------TEST DE ESTADO IN BOUND-------------------------
	@Test
	void test006_SePuedePasarDeEstadoInBoundAlEstadoOutBound() {
		buque.setEstado(inBound);
		
		inBound.pasarAEstadoOutOfBound(buque);
		
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	//*
	@Test
	void test007_NoSePuedePasarDeEstadoInBoundAlEstadoInBound() {
		
		buque.setEstado(inBound);
		
		assertThrows(IllegalStateException.class, () -> inBound.pasarAEstadoInBound(buque));
	}
	
	@Test
	void test008_SePuedePasarDeEstadoInBoundAlEstadoArrived() {
		
		buque.setEstado(inBound);
		
		inBound.pasarAEstadoArrived(buque);
		
		assertInstanceOf(Arrived.class, buque.getEstado());
		
	}
	
	@Test
	void test009_NoSePuedePasarDeEstadoInBoundAlEstadoWorking() {
		
		buque.setEstado(inBound);
		
		assertThrows(IllegalStateException.class, () -> inBound.pasarAEstadoWorking(buque));
	}
	
	@Test
	void test010_NoSePuedePasarDeEstadoInBoundAlEstadoDeparting() {
		
		buque.setEstado(inBound);
		
		assertThrows(IllegalStateException.class, () -> inBound.pasarAEstadoDeparting(buque));
	}
	//-------------TEST DE ESTADO ARRIVED-------------------------
	@Test
	void test011_NoSePuedePasarDelEstadoArrivedAlEstadoOutBound() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoOutOfBound(buque));
		
	}
	
	@Test
	void test012_NoSePuedePasarDelEstadoArrivedAlEstadoInBound() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoInBound(buque));
		
	}
	
	@Test
	void test013_NoSePuedePasarDelEstadoArrivedAlEstadoArrived() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test014_SePuedePasarDelEstadoArrivedAlEstadoWorking() {
		
		buque.setEstado(arrived);
		
		arrived.pasarAEstadoWorking(buque);
		
		assertInstanceOf(Working.class, buque.getEstado());
		
	}
	
	@Test
	void test015_NoSePuedePasarDelEstadoArrivedAlEstadoDeparting() {
		
		buque.setEstado(arrived);
		
		assertThrows(IllegalStateException.class, () -> arrived.pasarAEstadoDeparting(buque));
		
	}
	//-------------TEST DE ESTADO WORKING-------------------------
	@Test
	void test016_NoSePuedePasarDelEstadoWorkingAlEstadoOutBound() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoOutOfBound(buque));
		
	}
	
	@Test
	void test017_NoSePuedePasarDelEstadoWorkingAlEstadoInBound() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoInBound(buque));
		
	}
	
	@Test
	void test018_NoSePuedePasarDelEstadoWorkingAlEstadoArrived() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test019_NoSePuedePasarDelEstadoWorkingAlEstadoWorking() {
		
		buque.setEstado(working);
		
		assertThrows(IllegalStateException.class, () -> working.pasarAEstadoWorking(buque));
		
	}
	
	@Test
	void test020_SePuedePasarDelEstadoWorkingAlEstadoDeparting() {
		
		buque.setEstado(working);
		
		working.pasarAEstadoDeparting(buque);
		
		assertInstanceOf(Departing.class, buque.getEstado());
		
	}
	//-------------TEST DE ESTADO DEPARTING-------------------------
	@Test
	void test021_SePuedePasarDelEstadoDepartingAlEstadoOutBound() {
		
		buque.setEstado(departing);
		
		departing.pasarAEstadoOutOfBound(buque);
		
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	
	@Test
	void test022_NoSePuedePasarDelEstadoDepartingAlEstadoInBound() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoInBound(buque));
		
	}
	
	@Test
	void test023_NoSePuedePasarDelEstadoDepartingAlEstadoArrived() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test024_NoSePuedePasarDelEstadoDepartingAlEstadoWorking() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoWorking(buque));
		
	}
	
	@Test
	void test025_NoSePuedePasarDelEstadoDepartingAlEstadoDeparting() {
		
		buque.setEstado(departing);
		
		assertThrows(IllegalStateException.class, () -> departing.pasarAEstadoDeparting(buque));
		
	}
	
}
