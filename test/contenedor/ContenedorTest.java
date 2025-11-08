package contenedor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContenedorTest {

	Contenedor contenedorDry;
	
	@BeforeEach
	void setUp() throws Exception {
		
		contenedorDry = new Dry("lala", 123, 7.21, 8.3, 9.987, 3.23);
		
	}

	@Test
	void test001_UnContenedorConoceASuIdentificador() {
		
		assertEquals(contenedorDry.getIdentificador(), "lala123");
		
	}

	@Test
	void test002_UnContenedorConoceSuAncho() {
		
		assertEquals(contenedorDry.getAncho(), 7.21);
		
	}
	
	@Test
	void test003_UnContenedorConoceSuLargo() {
		
		assertEquals(contenedorDry.getLargo(), 8.3);
		
	}
	
	@Test
	void test004_UnContenedorConoceSuAltura() {
		
		assertEquals(contenedorDry.getAlto(), 9.987);
		
	}
	
	@Test
	void test005_UnContenedorConoceSuPeso() {
		
		assertEquals(contenedorDry.getPeso(), 3.23);
		
	}
}
