package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import empresa_naviera.*;
import empresa_transportista.Camion;
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
	void test004_CuandoUnaTerminalEliminaAUnaNavieraDeSuListaDeNavieras_LaListaDisminuye() {

		EmpresaNaviera naviera = mock(EmpresaNaviera.class);
		terminal.agregarNaviera(naviera);
		
		terminal.eliminarNaviera(naviera);
		
		assertTrue(terminal.getNavieras().isEmpty());
		assertFalse(terminal.getNavieras().contains(naviera));
		
	}
	
	@Test
	void test005_CuandoUnaTerminalAgregaUnaNuevaEmpresaTransportista_SuListaDeEmpresasTransportistasAumenta() {

		EmpresaTransportista transportista1 = mock(EmpresaTransportista.class);
		EmpresaTransportista transportista2 = mock(EmpresaTransportista.class);
		
		terminal.agregarEmpresaTransportista(transportista1);
		terminal.agregarEmpresaTransportista(transportista2);
		
		assertEquals(terminal.getEmpresasTransportistas().size(), 2);
		
		assertTrue(terminal.getEmpresasTransportistas().contains(transportista1));
		assertTrue(terminal.getEmpresasTransportistas().contains(transportista2));
		
	}
	
	@Test
	void test006_UnaTerminalNoPuedeAgregarALaMismaEmpresaTransportistaDosVeces() {

		EmpresaTransportista transportista = mock(EmpresaTransportista.class);
		terminal.agregarEmpresaTransportista(transportista);
		
		assertThrows(IllegalArgumentException.class, () -> terminal.agregarEmpresaTransportista(transportista));
		
		assertEquals(terminal.getEmpresasTransportistas().size(), 1);
		
	}
	
	@Test
	void test007_CuandoUnaTerminalEliminaAUnaEmpresaTransportistaDeSuListaDeEmpresasTransportistas_LaListaDisminuye() {

		EmpresaTransportista transportista = mock(EmpresaTransportista.class);
		terminal.agregarEmpresaTransportista(transportista);
		
		terminal.eliminarEmpresaTransportista(transportista);
		
		assertTrue(terminal.getEmpresasTransportistas().isEmpty());
		assertFalse(terminal.getEmpresasTransportistas().contains(transportista));
		
	}
	
	@Test
	void test008_UnaTerminalConoceSuCoordenada() {
		
        assertEquals(10.5, terminal.getCoordenada().getX());
        assertEquals(20.7, terminal.getCoordenada().getY());
    }
	
	@Test
	void test009_CuandoUnaTerminalRegistraUnNuevoCamion_SuListaDeCamionesAumenta() {
		
		Camion camion1 = mock(Camion.class);
		Camion camion2 = mock(Camion.class);
		terminal.registrarCamion(camion1);
		terminal.registrarCamion(camion2);
	
		assertEquals(terminal.getCamiones().size(), 2);
		
	}
	
	@Test
	void test010_UnaTerminalNoPuedeAgregarAlMismoCamionDosVeces() {

		Camion camion = mock(Camion.class);
		terminal.registrarCamion(camion);
		
		assertThrows(IllegalArgumentException.class, () -> terminal.registrarCamion(camion));
		
		assertEquals(terminal.getCamiones().size(),1);
		
	}
	
	@Test
	void test011_CuandoUnCamionSeRetiraDeLaTerminal_LaListaDeCamionesDisminuye() {
		
		Camion camion = mock(Camion.class);
		terminal.registrarCamion(camion);
		
		terminal.eliminarCamion(camion);
		
		assertTrue(terminal.getCamiones().isEmpty());
		assertFalse(terminal.getCamiones().contains(camion));
	}
	

}
