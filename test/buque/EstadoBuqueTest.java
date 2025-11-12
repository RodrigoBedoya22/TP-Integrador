package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;

import terminal_portuaria.Coordenada;

class EstadoBuqueTest {

	EstadoBuque outOfBound;
	EstadoBuque inBound;
	EstadoBuque arrived;
	EstadoBuque working;
	EstadoBuque departing;
	
	@BeforeEach
	void setUp() throws Exception {
		
		outOfBound = new OutOfBound();
		inBound = new InBound();
		arrived = new Arrived();
		working = new Working();
		departing = new Departing();
		
		
	}

	@Test
	void test001_ElBuqueConoceSuEstadoActual() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		
		
		assertThrows(IllegalArgumentException.class, () -> outOfBound.pasarAEstadoOutOfBound(buque));
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	
	@Test
	void test002_ElEstadoOutOfBoundSabeAQueEstadoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		
		outOfBound.pasarAEstadoInBound(buque);
		assertInstanceOf(InBound.class, buque.getEstado());
		
	}
	
	@Test
	void test003_ElEstadoOutOfBoundSabeAQueEstadosNoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		
		assertThrows(IllegalArgumentException.class, () -> outOfBound.pasarAEstadoArrived(buque));
		assertThrows(IllegalArgumentException.class, () -> outOfBound.pasarAEstadoWorking(buque));
		assertThrows(IllegalArgumentException.class, () -> outOfBound.pasarAEstadoDeparting(buque));
		
	}
	
	@Test
	void test004_ElEstadoInBoundSabeSuEstadoActual() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(inBound);
		
		
		assertThrows(IllegalArgumentException.class, () -> inBound.pasarAEstadoInBound(buque));
		assertInstanceOf(InBound.class, buque.getEstado());
		
	}
	
	@Test
	void test005_ElEstadoInBoundPuedeVolverAlEstadoOutOfBound() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(inBound);
		
		inBound.pasarAEstadoOutOfBound(buque);
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	
	@Test
	void test006_ElEstadoInBoundPuedePasarAlEstadoArrived() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(inBound);
		
		inBound.pasarAEstadoArrived(buque);
		assertInstanceOf(Arrived.class, buque.getEstado());

		
	}
	
	@Test
	void test007_ElEstadoInBoundSabeAQueEstadosNoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		
		assertThrows(IllegalArgumentException.class, () -> inBound.pasarAEstadoWorking(buque));
		assertThrows(IllegalArgumentException.class, () -> inBound.pasarAEstadoDeparting(buque));
		
	}
	
	@Test
	void test008_ElEstadoArrivedSabeSuEstadoActual() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(arrived);
		
		
		assertThrows(IllegalArgumentException.class, () -> arrived.pasarAEstadoArrived(buque));
		assertInstanceOf(Arrived.class, buque.getEstado());
		
	}
	
	@Test
	void test009_ElEstadoArrivedSabeAQueEstadoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(arrived);
		
		arrived.pasarAEstadoWorking(buque);
		assertInstanceOf(Working.class, buque.getEstado());
		
	}
	
	@Test
	void test010_ElEstadoArrivedSabeAQueEstadosNoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(arrived);
		
		assertThrows(IllegalArgumentException.class, () -> arrived.pasarAEstadoOutOfBound(buque));
		assertThrows(IllegalArgumentException.class, () -> arrived.pasarAEstadoInBound(buque));
		assertThrows(IllegalArgumentException.class, () -> arrived.pasarAEstadoDeparting(buque));
	}

	@Test
	void test011_ElEstadoWorkingSabeSuEstadoActual() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(working);
		
		
		assertThrows(IllegalArgumentException.class, () -> working.pasarAEstadoWorking(buque));
		assertInstanceOf(Working.class, buque.getEstado());
		
	}
	
	@Test
	void test012_ElEstadoWorkingSabeAQueEstadoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(working);
		
		working.pasarAEstadoDeparting(buque);
		assertInstanceOf(Departing.class, buque.getEstado());
		
	}
	
	@Test
	void test013_ElEstadoWorkingSabeAQueEstadosNoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(working);
		
		assertThrows(IllegalArgumentException.class, () -> working.pasarAEstadoOutOfBound(buque));
		assertThrows(IllegalArgumentException.class, () -> working.pasarAEstadoInBound(buque));
		assertThrows(IllegalArgumentException.class, () -> working.pasarAEstadoArrived(buque));
		
	}
	
	@Test
	void test014_ElEstadoDepartingSabeSuEstadoActual() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(departing);
		
		
		assertThrows(IllegalArgumentException.class, () -> departing.pasarAEstadoDeparting(buque));
		assertInstanceOf(Departing.class, buque.getEstado());
		
	}
	
	@Test
	void test015_ElEstadoDepartingSabeAQueEstadoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(departing);
		
		departing.pasarAEstadoOutOfBound(buque);
		assertInstanceOf(OutOfBound.class, buque.getEstado());
		
	}
	
	@Test
	void test016_ElEstadoOutOfBoundSabeAQueEstadosNoPuedePasar() {
		
		Coordenada coordenada = mock(Coordenada.class);
		Buque buque = new Buque("pepe", coordenada);
		buque.setEstado(departing);
		
		assertThrows(IllegalArgumentException.class, () -> departing.pasarAEstadoInBound(buque));
		assertThrows(IllegalArgumentException.class, () -> departing.pasarAEstadoWorking(buque));
		assertThrows(IllegalArgumentException.class, () -> departing.pasarAEstadoArrived(buque));
		
	}
}
