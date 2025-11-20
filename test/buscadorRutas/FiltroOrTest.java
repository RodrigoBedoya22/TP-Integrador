package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.BuqueViaje;
import empresa_naviera.CircuitoMaritimo;
import empresa_naviera.Tramo;

class FiltroOrTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void Test001_elViajeCumpleConElFiltroOr() {
		FiltroOr filtroOr = new FiltroOr(new FiltroPuertoDestino("Terminal A"), new FiltroPuertoDestino("Terminal B"));
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(true);
		when(circuito.contieneTramoConDestino("Terminal B")).thenReturn(true);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, LocalDate.of(2005, 3, 31));

        assertTrue(filtroOr.cumple(viaje));
	}
	
	@Test
	void Test002_elViajeCumpleConElFiltroOrTeniendoAlMenosUnaTerminalCorrespondiente() {
		FiltroOr filtroOr = new FiltroOr(new FiltroPuertoDestino("Terminal A"), new FiltroPuertoDestino("Terminal B"));
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(true);
		when(circuito.contieneTramoConDestino("Terminal B")).thenReturn(false);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, LocalDate.of(2005, 5, 21));

        assertTrue(filtroOr.cumple(viaje));
	}
	
	@Test
	void Test003_elViajeCumpleConElFiltroOrTeniendoAlMenosUnaTerminalCorrespondiente2() {
		FiltroOr filtroOr = new FiltroOr(new FiltroPuertoDestino("Terminal A"), new FiltroPuertoDestino("Terminal B"));
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(false);
		when(circuito.contieneTramoConDestino("Terminal B")).thenReturn(true);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, LocalDate.of(2002, 3, 31));

        assertTrue(filtroOr.cumple(viaje));
	}
	
	@Test
	void Test004_elViajeNoCumpleConElFiltroOr() {
		FiltroOr filtroOr = new FiltroOr(new FiltroPuertoDestino("Terminal A"), new FiltroPuertoDestino("Terminal B"));
		CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
		when(circuito.contieneTramoConDestino("Terminal A")).thenReturn(false);
		when(circuito.contieneTramoConDestino("Terminal B")).thenReturn(false);
		
		ArrayList<Tramo> tramos = new ArrayList<>();
	    Tramo tramoMock = mock(Tramo.class);
	    tramos.add(tramoMock);
	    when(circuito.getTramos()).thenReturn(tramos);
	    
		BuqueViaje viaje = new BuqueViaje(null, circuito, LocalDate.of(1995, 4, 1));

        assertFalse(filtroOr.cumple(viaje));
	}


}
