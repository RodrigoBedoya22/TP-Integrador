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

class FiltroFechaDeSalidaTest {


	@BeforeEach
	void setUp() throws Exception {
	}
    
	/*
	void Test001_elFiltroFechaDeSalidaCoincideConLaFechaDeSalidaQueTieneElViaje() {
		
		FiltroFechaDeSalida filtro= new FiltroFechaDeSalida(LocalDate.of(2025, 6, 29));
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeSalida()).thenReturn(LocalDate.of(2025, 6, 25));
		when(viaje.fechaDeSalidaDesde("Terminal Gestionada")).thenReturn(LocalDate.of(2025, 6, 29));
		
        assertTrue(filtro.cumple(viaje));
	}
	*/

}
