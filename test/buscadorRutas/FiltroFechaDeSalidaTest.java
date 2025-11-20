package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import empresa_naviera.BuqueViaje;


class FiltroFechaDeSalidaTest {


	@BeforeEach
	void setUp() throws Exception {
	}
    
	@Test
	void Test001_elFiltroFechaDeSalidaCoincideConLaFechaDeSalidaQueTieneElViaje() {
		
		FiltroFechaDeSalida filtro= new FiltroFechaDeSalida(LocalDate.of(2025, 6, 29), "Terminal Gestionada");
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA("Terminal Gestionada")).thenReturn(LocalDate.of(2025, 6, 29));
		
        assertTrue(filtro.cumple(viaje));
	}
	
	@Test
    void Test002_elFiltroFechaDeSalidaNoCoincideConLaFechaDeSalidaQueTieneElViaje() {
		
		FiltroFechaDeSalida filtro= new FiltroFechaDeSalida(LocalDate.of(2025, 4, 29), "Terminal Gestionada");
		BuqueViaje viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA("Terminal Gestionada")).thenReturn(LocalDate.of(2025, 5, 29));
		
        assertFalse(filtro.cumple(viaje));
	}

}
