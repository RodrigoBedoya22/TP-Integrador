package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coordenada.Coordenada;
import terminal_portuaria.*;

class TramoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test001_UnTramoConoceASuTerminalOrigen_YTambienASuTerminalDestino() throws Exception{
		
		TerminalPortuaria terminalOrigen = mock(TerminalPortuaria.class);
		TerminalPortuaria terminalDestino = mock(TerminalPortuaria.class);
		
		Tramo tramo = new Tramo(terminalOrigen, terminalDestino, 300000.0);
		
		assertEquals(tramo.getTerminalOrigen(), terminalOrigen);
		assertEquals(tramo.getTerminalDestino(), terminalDestino);
		
	}
	
	@Test
	void test002_UnTramoConoceSuDuracionSegunLaDistanciaEntreSusTerminales() throws Exception{
		//DOCS
		TerminalPortuaria terminalOrigen = new TerminalPortuaria("Terminal A", new Coordenada(10, 200));
		TerminalPortuaria terminalDestino = new TerminalPortuaria("Terminal B", new Coordenada(500, 2000));
		
		//SUT
		Tramo tramo = new Tramo(terminalOrigen, terminalDestino, 100000.0);
		
		assertEquals(tramo.getDuracion(), 1865.5);	
		
	}
	
	@Test
	void test003_UnTramoConoceSuPrecio() throws Exception {
		
		TerminalPortuaria terminalOrigen = mock(TerminalPortuaria.class);
		TerminalPortuaria terminalDestino = mock(TerminalPortuaria.class);
		
		Tramo tramo = new Tramo(terminalOrigen, terminalDestino, 300000.0);
		
		assertEquals(tramo.getPrecio(), 300000.0);
	}
	
	@Test
	void test004_ElPrecioDeUnTramoNoPuedeSerNegativoOCero() throws Exception{
		
		TerminalPortuaria terminalOrigen = mock(TerminalPortuaria.class);
		TerminalPortuaria terminalDestino = mock(TerminalPortuaria.class);

		Tramo tramo = new Tramo(terminalOrigen, terminalDestino, 300000.0);
		
		assertThrows(IllegalArgumentException.class, () -> tramo.setPrecio(-10000.0));
		assertThrows(IllegalArgumentException.class, () -> tramo.setPrecio(0.0));
	}

}
