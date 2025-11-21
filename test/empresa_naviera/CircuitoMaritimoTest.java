package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import coordenada.Coordenada;
import terminal_portuaria.*;

class CircuitoMaritimoTest {
	
	TerminalPortuaria terminalA, terminalB, terminalC, terminalD;
	Tramo tramoAB, tramoBC, tramoCA, tramoCD, tramoDB;

	@BeforeEach
	void setUp() throws Exception {
		terminalA = new TerminalPortuaria("Terminal A", new Coordenada(10, 222));
		terminalB = new TerminalPortuaria("Terminal B", new Coordenada(102, 5));
		terminalC = new TerminalPortuaria("Terminal C", new Coordenada(0, 33));
		terminalD = new TerminalPortuaria("Terminal D", new Coordenada(56, 73));
		
		
		tramoAB = new Tramo(terminalA, terminalB, 10000.0);
		tramoBC = new Tramo(terminalB, terminalC, 10000.0);
		tramoCA = new Tramo(terminalC, terminalA, 10000.0);
		tramoDB = new Tramo(terminalD, terminalB, 10000.0);
		tramoCD = new Tramo(terminalC, terminalD, 10000.0);
	}

	@Test
	void test001_UnCircuitoMaritimoConoceASusTramos() {
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		assertEquals(circuito.getTramos(), listaDeTramos);
	}
	
	@Test
	void test002_UnCircuitoConoceSuDuracionDeViajeBasandoseEnSusTramos() throws Exception {
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		assertEquals(circuito.getDuracion(), 22);
		
	}
	
	@Test
	void test003_UnCircuitoNoPuedeTenerUnaListaDeTramosVacios() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		
		assertThrows(IllegalArgumentException.class, () -> new CircuitoMaritimo(listaDeTramos));
		 
	}
	
	@Test
	void test004_AlCrearUnCircuito_SiElUltimoTramoNoTieneComoDestinoElOrigenDelPrimerTramo_SeLanzaUnaExcepcion() {
		ArrayList<Tramo> listaDeTramos = new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCD);
		
		assertThrows(IllegalArgumentException.class, () -> new CircuitoMaritimo(listaDeTramos));
	}
	
	@Test
	void test004_CuandoUnCircuitoEsInstanciado_SeValidaQueSusTramosEstenBienConstruidos() {
		ArrayList<Tramo> listaDeTramos = new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		assertTrue(circuito.validarListaDeTramos(listaDeTramos));
		
	}
	
	@Test
	void test004_UnCircuitoTieneTramosValidos() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoDB);
		
		assertThrows(IllegalArgumentException.class, () -> new CircuitoMaritimo(listaDeTramos));
		 
	}
	
	@Test
	void test005_UnCircuitoContieneUnTramoDestinoDeNombreDado(){
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		assertTrue(circuito.contieneTramoConDestino("Terminal C"));
		 
	}
	
	@Test
	void test006_UnCircuitoMaritimoSabeElPrecioDeSuRecorrido() {
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		assertEquals(circuito.getPrecio(), 30000);
		
	}
	

}
