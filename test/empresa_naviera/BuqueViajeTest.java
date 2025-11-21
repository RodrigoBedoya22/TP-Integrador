package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import coordenada.Coordenada;
import terminal_portuaria.*;

class BuqueViajeTest {
	
	Buque buque;
	BuqueViaje viaje;
	TerminalPortuaria terminalA, terminalB, terminalC, terminalD;
	Tramo tramoAB, tramoBC, tramoCA, tramoDB;
	CircuitoMaritimo circuito;
	

	@BeforeEach
	void setUp() throws Exception {
		
	   buque= new Buque("Titanic");
	   
	   terminalA = new TerminalPortuaria("Terminal A", new Coordenada(10, 222));
	   terminalB = new TerminalPortuaria("Terminal B", new Coordenada(102, 5));
	   terminalC = new TerminalPortuaria("Terminal C", new Coordenada(0, 33));
	   terminalD = new TerminalPortuaria("Terminal D", new Coordenada(56, 73));
		
	   tramoAB = new Tramo(terminalA, terminalB, 10000.0);
	   tramoBC = new Tramo(terminalB, terminalC, 10000.0);
	   tramoCA = new Tramo(terminalC, terminalA, 10000.0);
	   tramoDB = new Tramo(terminalD, terminalB, 10000.0);
	   
	   
	}

	@Test
	void test001UnBuqueViajeConoceAlBuqueQueVaAViajar() {
		 
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fecha);
		assertTrue(viaje.getBuque() == buque);
	}
	
	@Test
	void test002UnBuqueViajeConoceSuCircuito() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
		
		viaje= new BuqueViaje(buque,circuito,fecha);
		assertTrue(viaje.getCircuito() == circuito);
	}
	
	@Test
	void test003UnBuqueViajeConoceSuTramoActual() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fecha);
		assertTrue(viaje.getTramoActual() == tramoAB);
	}
	
	@Test
	void test004UnBuqueViajeCambiaSuTramoActualPorOtroTramoActual() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito,fecha);
		viaje.pasarASiguienteTramo();
		
		assertTrue(viaje.getTramoActual() == tramoBC);
	}
	
	@Test
	void test005UnBuqueViajeConoceSuFechaDeSalida() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fecha);
		
		assertTrue(viaje.getFechaDeSalida() == fecha);
	}
	

	@Test
	void test006UnBuqueViajeConoceLaFechaDeLlegadaASuDestinoActual() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fecha);
		
		
		assertEquals(viaje.getFechaDeLlegadaA("Terminal B"), fecha.plusDays(tramoAB.getDuracion()));
	}
	
	@Test
	void test007_UnBuqueViajeConoceLaDuracionDeSuRecorrido() {
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fecha);
		
		assertEquals(viaje.getDuracion(), 22);
		
	}
	
	@Test
	void test008_UnBuqueViajeConoceElPrecioDeSuRecorrido() {
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fecha = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fecha);
		
		assertEquals(viaje.getPrecio(), 30000);
		
	}
	
	@Test
	void test009_UnBuqueViajeSabeLaFechaDeLlegadaDeUnTramo() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fechaDeSalidaInicial = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fechaDeSalidaInicial);
		
		
		assertEquals(viaje.getFechaDeLlegadaA("Terminal B"), fechaDeSalidaInicial.plusDays(tramoAB.getDuracion()));
	}
	
	@Test
	void test010_UnBuqueViajeConoceSuCantidadDeTramos() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		LocalDate fechaDeSalidaInicial = LocalDate.of(1990, 10, 23);
	    
		viaje= new BuqueViaje(buque,circuito, fechaDeSalidaInicial);
		
		
		assertEquals(viaje.cantidadDeTramos(), 3);
	}
	

}
