package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import empresa_naviera.*;
import empresa_transportista.EmpresaTransportista;


class TerminalPortuariaTest {

	TerminalPortuaria terminal;

	@BeforeEach
	void setUp() throws Exception {
		
		Coordenada coordenada = new Coordenada(10.5, 20.7);
		terminal = new TerminalPortuaria("ElAtlantico", coordenada);

		
	}

	@Test
	void test001_UnaTerminalPortuariaConoceSuNombre() {
		
		assertEquals(terminal.getNombre(), "ElAtlantico");
		
	}
	
	@Test
	void test002_CuandoUnaTerminalAgregaUnaNuevaNaviera_SuListaDeNavierasAumenta() {

		EmpresaNaviera naviera1 = mock(EmpresaNaviera.class);
		EmpresaNaviera naviera2 = mock(EmpresaNaviera.class);
		EmpresaNaviera naviera3 = mock(EmpresaNaviera.class);
		
		terminal.agregarNaviera(naviera1);
		terminal.agregarNaviera(naviera2);
		terminal.agregarNaviera(naviera3);
		
		assertEquals(terminal.getNavieras().size(), 3);
		
	}
	
	@Test
	void test003_UnaTerminalNoPuedeAgregarALaMismaNavieraDosVeces() {

		EmpresaNaviera naviera = mock(EmpresaNaviera.class);
		terminal.agregarNaviera(naviera);
		
		assertThrows(IllegalArgumentException.class, () -> terminal.agregarNaviera(naviera));
		
		assertEquals(terminal.getNavieras().size(), 1);
		
	}
	
	@Test
	void test004_CuandoUnaTerminalAgregaUnaNuevaEmpresaTransportista_SuListaDeEmpresasTransportistasAumenta() {

		EmpresaTransportista transportista1 = mock(EmpresaTransportista.class);
		EmpresaTransportista transportista2 = mock(EmpresaTransportista.class);
		
		terminal.agregarEmpresaTransportista(transportista1);
		terminal.agregarEmpresaTransportista(transportista2);
		
		assertEquals(terminal.getEmpresasTransportistas().size(), 2);
		
		assertTrue(terminal.getEmpresasTransportistas().contains(transportista1));
		assertTrue(terminal.getEmpresasTransportistas().contains(transportista2));
		
	}
	
	@Test
	void test005_UnaTerminalNoPuedeAgregarALaMismaEmpresaTransportistaDosVeces() {

		EmpresaTransportista transportista = mock(EmpresaTransportista.class);
		terminal.agregarEmpresaTransportista(transportista);
		
		assertThrows(IllegalArgumentException.class, () -> terminal.agregarEmpresaTransportista(transportista));
		
		assertEquals(terminal.getEmpresasTransportistas().size(), 1);
		
	}
	
	@Test
	void test006_CuandoUnaTerminalConoceSuCoordenada() {
        assertEquals(10.5, terminal.getCoordenada().getX());
        assertEquals(20.7, terminal.getCoordenada().getY());
    }
	

}
