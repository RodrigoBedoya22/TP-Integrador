package contenedor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContenedorTest {

	Contenedor contenedorDry;
	Contenedor contenedorReefer;
	Contenedor contenedorTanque;
	
	@BeforeEach
	void setUp() throws Exception {
		
		contenedorDry = new Dry("lala", 1234567, 7.21, 8.3, 9.987, 3.23);
		contenedorReefer = new Reefer("paro", 1111111, 8.1, 9.0, 7.2, 8.98);
		contenedorTanque = new Tanque("cero", 9999999, 9.1, 7.2, 5.5, 6.6);
		
	}

	@Test
	void test001_UnContenedorConoceASuIdentificador() {
		
		assertEquals(contenedorDry.getIdentificador(), "lala1234567");
		assertEquals(contenedorReefer.getIdentificador(), "paro1111111");
		assertEquals(contenedorTanque.getIdentificador(), "cero9999999");
		
	}

	@Test
	void test002_UnContenedorConoceSuAncho() {
		
		assertEquals(contenedorDry.getAncho(), 7.21);
		assertEquals(contenedorReefer.getAncho(), 8.1);
		assertEquals(contenedorTanque.getAncho(), 9.1);
		
	}
	
	@Test
	void test003_UnContenedorConoceSuLargo() {
		
		assertEquals(contenedorDry.getLargo(), 8.3);
		assertEquals(contenedorReefer.getLargo(), 9.0);
		assertEquals(contenedorTanque.getLargo(), 7.2);
		
	}
	
	@Test
	void test004_UnContenedorConoceSuAltura() {
		
		assertEquals(contenedorDry.getAlto(), 9.987);
		assertEquals(contenedorReefer.getAlto(), 7.2);
		assertEquals(contenedorTanque.getAlto(), 5.5);
		
	}
	
	@Test
	void test005_UnContenedorConoceSuPeso() {
		
		assertEquals(contenedorDry.getPeso(), 3.23);
		assertEquals(contenedorReefer.getPeso(), 8.98);
		assertEquals(contenedorTanque.getPeso(), 6.6);
		
	}
	
	@Test
	void test006_UnContenedorConoceSuTipo() {
		
		assertEquals(contenedorDry.tipo(), "dry");
		assertEquals(contenedorReefer.tipo(), "reefer");
		assertEquals(contenedorTanque.tipo(), "tanque");
		
	}
}
