package contenedor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;

class TanqueTest {

	Tanque contenedorTanque;
	BlBasico carga;
	
	@BeforeEach
	void setUp() throws Exception {
		
		carga = mock(BlBasico.class);
		contenedorTanque = new Tanque("paro", 1111111, 8.1, 9.0, 7.2, 8.98, carga);
	}

	@Test
	void test001_UnContenedorConoceASuIdentificador() {
		
		assertEquals(contenedorTanque.getIdentificador(), "paro1111111");
		
	}

	@Test
	void test002_UnContenedorConoceSuAncho() {
		
		assertEquals(contenedorTanque.getAncho(), 8.1);
		
	}
	
	@Test
	void test003_UnContenedorConoceSuLargo() {
		
		assertEquals(contenedorTanque.getLargo(), 9.0);
		
	}
	
	@Test
	void test004_UnContenedorConoceSuAltura() {
		
		assertEquals(contenedorTanque.getAlto(), 7.2);
		
	}
	
	@Test
	void test005_UnContenedorConoceSuPeso() {
		
		assertEquals(contenedorTanque.getPeso(), 8.98);
		
	}
	
	@Test
	void test006_UnContenedorConoceSusMetrosCubicosBasandoseEnSusMedidas() {
		
		assertEquals(contenedorTanque.metrosCubicos(), 524.88);
		
	}
	
	@Test
	void test007_UnContenedorTanqueConoceSuCarga() {
		
		assertEquals(contenedorTanque.getCarga(), carga);
		
	}
	
	@Test
	void test008_UnContenedorTanqueNoConsumeEnergia() {
		assertEquals(contenedorTanque.getConsumoDeEnergía(), 0);
	}
	

	@Test
	void test009_UnContenedorTanqueSabeSuTipo() {
		assertEquals(contenedorTanque.getTipo(), "Tanque");
	}

}
