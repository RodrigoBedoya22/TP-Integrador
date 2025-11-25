package servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTest {
	
	Servicio servicio;
	
	@BeforeEach
	void setUp() throws Exception {
		servicio = new Lavado("Lavado", 400);
	}

	@Test
	void test001_UnServicioConoceSuNombre(){
		assertEquals(servicio.getNombre(), "Lavado");
	}
	@Test
	void test002_UnServicioConoceSuPrecioBaseFijo() {
		assertEquals(servicio.getPrecioFijo(), 400);
	}
	@Test
	void test003_ElServicioPuedeCambiarDePrecio() {
		
		servicio.setPrecioFijo(500);
		assertEquals(servicio.getPrecioFijo(), 500);
		
	}
	
	@Test
	void test004_UnServicioNoPuedeTenerUnPrecioBaseFijoNegativoOCero() {
				
		assertThrows(IllegalArgumentException.class, () -> new Lavado("Lavado1", -500));
		assertThrows(IllegalArgumentException.class, () -> new Lavado("Lavado1", 0));
	}

}
