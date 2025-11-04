package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
