package contenedor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;

class DryTest {

	Dry contenedorDry;
	BlBasico carga;
	
	@BeforeEach
	void setUp() throws Exception {
		
		carga = mock(BlBasico.class);
		contenedorDry = new Dry("paro", 1111111, 8.1, 9.0, 7.2, 8.98, carga);
	}

	@Test
	void test001_UnContenedorConoceASuIdentificador() {
		
		assertEquals(contenedorDry.getIdentificador(), "paro1111111");
		
	}

	@Test
	void test002_UnContenedorConoceSuAncho() {
		
		assertEquals(contenedorDry.getAncho(), 8.1);
		
	}
	
	@Test
	void test003_UnContenedorConoceSuLargo() {
		
		assertEquals(contenedorDry.getLargo(), 9.0);
		
	}
	
	@Test
	void test004_UnContenedorConoceSuAltura() {
		
		assertEquals(contenedorDry.getAlto(), 7.2);
		
	}
	
	@Test
	void test005_UnContenedorConoceSuPeso() {
		
		assertEquals(contenedorDry.getPeso(), 8.98);
		
	}
	
	@Test
	void test006_UnContenedorConoceSusMetrosCubicosBasandoseEnSusMedidas() {
		
		assertEquals(contenedorDry.metrosCubicos(), 524.88);
		
	}
	
	@Test
	void test008_UnContenedorDryTieneUnConsumoDeEnergiaCero() {
		assertEquals(contenedorDry.getConsumoDeEnergía(), 0);
	}

}
