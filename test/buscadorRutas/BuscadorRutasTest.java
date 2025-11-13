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
	
	@Test
	void test002_UnBuscadorTienePorDefectoLaEstrategiaMenorTiempo(){
		
	    TerminalPortuaria terminal = mock(TerminalPortuaria.class);
	    BuscadorRutas buscador= new BuscadorRutas(terminal);

	    assertInstanceOf(EstrategiaMenorTiempo.class, buscador.getEstrategia());
	}
	
	@Test
	void test003_SiElBuscadorCambiaDeEstrategia_SuEstrategiaCambia(){
		
	    TerminalPortuaria terminal = mock(TerminalPortuaria.class);
	    BuscadorRutas buscador= new BuscadorRutas(terminal);
	    EstrategiaMenorPrecio nuevaEstrategia = new EstrategiaMenorPrecio();
	    
	    buscador.setEstrategia(nuevaEstrategia);

	    assertInstanceOf(EstrategiaMenorPrecio.class, buscador.getEstrategia());
	}
	
	

}
