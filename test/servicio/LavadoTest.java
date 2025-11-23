package servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.Bl;
import bl.BlBasico;
import contenedor.Dry;
import orden.Orden;
import orden.OrdenExportacion;
import orden.OrdenImportacion;

class LavadoTest {
	
	Lavado lavado;
	Dry contenedor, contenedor2;
	Bl carga;
	Orden orden1, orden2;

	@BeforeEach
	void setUp() throws Exception {
		carga = mock(BlBasico.class);
		lavado = new Lavado(500);
		contenedor2 = new Dry("tata", 1234567, 5.00, 5.00, 10.00, 75.00, carga);
		contenedor = new Dry("pepe", 7654321, 2.00, 2.00, 10.00, 75.00, carga);
		
		ArrayList<Servicio> lista= new ArrayList<Servicio>();
		lista.add(lavado);
		
		
		orden1 = new OrdenExportacion(null, contenedor, null, null, lista, null, null, null);
		orden2 = new OrdenExportacion(null, contenedor2, null, null, lista, null, null, null);
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
		
		assertTrue(orden1.getContenedor().metrosCubicos() < 70.0);
		assertEquals(orden1.calcularCostoTotalDeServicios(), 500);
		
	}
	
	@Test
	void test004_ElServicioDeLavadoCobraElDobleSuPrecioFijoBaseAUnContenedorDe70MetrosCubicosOMás() {
		
		assertTrue(orden2.getContenedor().metrosCubicos() >= 70);
		assertEquals(orden2.calcularCostoTotalDeServicios(), 1000);
		
	}
	
	@Test
	void test005_UnServicioDeLavadoNoPuedeTenerSuPrecioBaseFijoEnNegativo() {
		assertThrows(IllegalArgumentException.class, () -> new Lavado(-500));
	}
	
	
	
}
