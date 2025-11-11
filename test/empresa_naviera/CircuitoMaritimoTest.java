package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.*;

class CircuitoMaritimoTest {
	
	TerminalPortuaria terminalA, terminalB, terminalC;
	Tramo tramoAB, tramoBC, tramoCA;

	@BeforeEach
	void setUp() throws Exception {
		terminalA = new TerminalPortuaria("Terminal A", new Coordenada(10, 222));
		terminalB = new TerminalPortuaria("Terminal B", new Coordenada(102, 5));
		terminalC = new TerminalPortuaria("Terminal C", new Coordenada(0, 33));
		
		tramoAB = new Tramo(terminalA, terminalB, 10000.0);
		tramoBC = new Tramo(terminalB, terminalC, 10000.0);
		tramoCA = new Tramo(terminalC, terminalA, 10000.0);
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
		
		assertEquals(circuito.getDuracion(), 530.73 );
		
	}

}
