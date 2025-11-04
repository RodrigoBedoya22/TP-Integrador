package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import empresa_naviera.*;


class TerminalPortuariaTest {

	TerminalPortuaria terminal;

	@BeforeEach
	void setUp() throws Exception {
		
		terminal = new TerminalPortuaria("ElAtlantico");
		
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

}
