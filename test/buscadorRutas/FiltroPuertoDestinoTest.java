package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.BuqueViaje;
import empresa_naviera.CircuitoMaritimo;
import empresa_naviera.Tramo;
import terminal_portuaria.Coordenada;
import terminal_portuaria.TerminalPortuaria;

class FiltroPuertoDestinoTest {

	@BeforeEach
	void setUp() throws Exception {
		

	}

	@Test
	void Test001_elFiltroDePuertoDestinoCumpleConElViaje() {
		FiltroPuertoDestino filtro= new FiltroPuertoDestino("Terminal A");
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(true);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, null);

        assertTrue(filtro.cumple(viaje));
	}
	
	@Test
	void Test002_elFiltroDePuertoDestinoNoCumpleConElViaje() {
		FiltroPuertoDestino filtro= new FiltroPuertoDestino("Terminal A");
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal T")).thenReturn(false);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, null);

        assertFalse(filtro.cumple(viaje));
	}



}
