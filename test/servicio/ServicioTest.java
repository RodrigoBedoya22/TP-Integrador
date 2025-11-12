package servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Dry;

class ServicioTest {

	Servicio lavado, pesado;
	Dry contenedor, contenedor2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		lavado = new Lavado(500);
		pesado = new Pesado(1500);
		contenedor = new Dry("tata", 1234567, 5.00, 5.00, 10.00, 75.00);
		contenedor2 = new Dry("pepe", 7654321, 2.00, 2.00, 10.00, 75.00);
		
		
	}

	@Test
	void test001_ElServicioDeLavadoSabeCuantoCobrarSegunElPesoDelContenedor() {
		
		assertEquals(lavado.calcularCosto(contenedor), 1000);
		assertEquals(lavado.calcularCosto(contenedor2), 500);
		
	}
	
	@Test
	void test002_ElServicioDePesadoSabeCuantoCobrar() {
		
		assertEquals(pesado.calcularCosto(contenedor), 1500);
		
	}

}
