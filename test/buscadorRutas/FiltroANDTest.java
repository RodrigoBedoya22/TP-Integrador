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

class FiltroANDTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void Test001_elViajeCumpleConElFiltro() {
		FiltroAnd filtroAnd = new FiltroAnd(new FiltroPuertoDestino("Terminal A"), new FiltroPuertoDestino("Terminal B"));
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(true);
		when(circuito.contieneTramoConDestino("Terminal B")).thenReturn(true);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, null);

        assertTrue(filtroAnd.cumple(viaje));
	}
	
	@Test
	void Test002_elViajeNoCumpleConElFiltro() {
		FiltroAnd filtroAnd = new FiltroAnd(new FiltroPuertoDestino("Terminal A"), new FiltroPuertoDestino("Terminal B"));
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(false);
		when(circuito.contieneTramoConDestino("Terminal B")).thenReturn(true);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, null);

        assertFalse(filtroAnd.cumple(viaje));
	}

	

}
