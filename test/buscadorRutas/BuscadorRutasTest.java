package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import terminal_portuaria.Coordenada;
import terminal_portuaria.TerminalPortuaria;

class BuscadorRutasTest {
	
	BuscadorRutas buscador;
	TerminalPortuaria terminal;
	Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test001_UnBuscadorConoceASuTerminalPortuaria(){
		
	    TerminalPortuaria terminal = mock(TerminalPortuaria.class);
	    BuscadorRutas buscador= new BuscadorRutas(terminal);

	    assertEquals(buscador.getTerminal(), terminal);
	
	}

}
