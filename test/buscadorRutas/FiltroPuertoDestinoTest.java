package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import empresa_naviera.CircuitoMaritimo;
import empresa_naviera.Tramo;
import terminal_portuaria.TerminalPortuaria;

class FiltroPuertoDestinoTest {

	@BeforeEach
	void setUp() throws Exception {
		

	}

	@Test
	void Test001_elFiltroDePuertoDestinoCoincideConElDestinoQueTieneElViaje() {
		FiltroPuertoDestino filtro= new FiltroPuertoDestino("Terminal A");
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.contieneTramoConDestino("Terminal A")).thenReturn(true);

        assertTrue(filtro.cumple(viaje));
	}
	
	@Test
	void Test002_elFiltroDePuertoDestinoNoCoincideConElDestinoQueTienelViaje() {
	    
	    FiltroPuertoDestino filtro= new FiltroPuertoDestino("Terminal B");
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.contieneTramoConDestino("Terminal T")).thenReturn(false);

        assertFalse(filtro.cumple(viaje));
	}



}
