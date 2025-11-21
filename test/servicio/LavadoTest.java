package servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Dry;

class LavadoTest {
	
	Lavado lavado;
	Dry contenedor, contenedor2;

	@BeforeEach
	void setUp() throws Exception {
		lavado = new Lavado(500);
		contenedor2 = new Dry("tata", 1234567, 5.00, 5.00, 10.00, 75.00);
		contenedor = new Dry("pepe", 7654321, 2.00, 2.00, 10.00, 75.00);
	}

	@Test
	void test001_UnServicioDeLavadoConoceSuPrecioBaseFijo() {
		assertEquals(lavado.getPrecioFijo(), 500);
	}
	
	@Test
	void test002_SiUnServicioDeLavadoCambiaSuPrecio_SuPrecioSeActualiza() {
		lavado.setPrecioFijo(1000);
		assertEquals(lavado.getPrecioFijo(), 1000);
	}
	@Test
	void test003_ElServicioDeLavadoCobraSuPrecioFijoBaseAUnContenedorDeMenosDe70MetrosCubicos() {
		
		assertTrue(contenedor.metrosCubicos() < 70.0);
		assertEquals(lavado.calcularCosto(contenedor), 500);
		
	}
	
	@Test
	void test004_ElServicioDeLavadoCobraElDobleSuPrecioFijoBaseAUnContenedorDe70MetrosCubicosOMás() {
		
		assertTrue(contenedor2.metrosCubicos() >= 70);
		assertEquals(lavado.calcularCosto(contenedor2), 1000);
		
	}
	
}
