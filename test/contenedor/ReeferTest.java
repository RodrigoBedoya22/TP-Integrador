package contenedor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;

class ReeferTest {

	Reefer contenedorReefer;
	BlBasico carga;
	
	@BeforeEach
	void setUp() throws Exception {
		
		carga = mock(BlBasico.class);
		contenedorReefer = new Reefer("paro", 1111111, 8.1, 9.0, 7.2, 8.98, 10, carga);
	}

	@Test
	void test001_UnContenedorConoceASuIdentificador() {
		
		assertEquals(contenedorReefer.getIdentificador(), "paro1111111");
		
	}

	@Test
	void test002_UnContenedorConoceSuAncho() {
		
		assertEquals(contenedorReefer.getAncho(), 8.1);
		
	}
	
	@Test
	void test003_UnContenedorConoceSuLargo() {
		
		assertEquals(contenedorReefer.getLargo(), 9.0);
		
	}
	
	@Test
	void test004_UnContenedorConoceSuAltura() {
		
		assertEquals(contenedorReefer.getAlto(), 7.2);
		
	}
	
	@Test
	void test005_UnContenedorConoceSuPeso() {
		
		assertEquals(contenedorReefer.getPeso(), 8.98);
		
	}
	
	@Test
	void test006_UnContenedorConoceSusMetrosCubicosBasandoseEnSusMedidas() {
		
		assertEquals(contenedorReefer.metrosCubicos(), 524.88);
		
	}
	
	@Test
	void test007_UnContenedorReeferConoceSuCarga() {
		
		assertEquals(contenedorReefer.getCarga(), carga);
		
	}
	
	@Test
	void test008_UnContenedorReeferConoceSuConsumoDeEnergiaKwH(){
		
		assertEquals(contenedorReefer.getConsumoDeEnergía(), 10);
	}

}

















