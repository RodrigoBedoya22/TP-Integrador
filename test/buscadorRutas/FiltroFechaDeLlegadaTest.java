package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.BuqueViaje;

class FiltroFechaDeLlegadaTest {

	@BeforeEach
	void setUp() throws Exception {
	}
    
	@Test
	void Test001_elFiltroFechaDeLlegadaCoincideConLaFechaDeLlegadaQueTieneElViaje() {
		
		FiltroFechaDeLlegada filtro= new FiltroFechaDeLlegada(LocalDate.of(2025, 6, 29), "Terminal Gestionada");
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA("Terminal Gestionada")).thenReturn(LocalDate.of(2025, 6, 29));
		
        assertTrue(filtro.cumple(viaje));
	}
	
	@Test
    void Test002_elFiltroFechaDeLlegadaNoCoincideConLaFechaDeLlegadaQueTieneElViaje() {
		
		FiltroFechaDeLlegada filtro= new FiltroFechaDeLlegada(LocalDate.of(2025, 8, 29), "Terminal Gestionada");
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA("Terminal Gestionada")).thenReturn(LocalDate.of(2025, 10, 29));
		
        assertFalse(filtro.cumple(viaje));
	}

}
