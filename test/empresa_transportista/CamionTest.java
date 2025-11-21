package empresa_transportista;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Dry;

class CamionTest {

	Camion camion;
	
	@BeforeEach
	void setUp() throws Exception {
		
		camion = new Camion("ABC 123");
		
	}

	@Test
	void test001_ElCamionConoceSuPatente() {
		
		assertTrue(camion.getPatente() == "ABC 123");
		
	}
	
	@Test
	void test002_ElCamionConoceAQuienLoConduce() {
		
		Chofer chofer = mock(Chofer.class);
		
		camion.setChofer(chofer);
		
		assertTrue(camion.getChofer() == chofer);
		
	}	
	
	@Test
	void test003_CuandoUnCamionEsInstanciado_NoTieneUnContenedor() {
		assertEquals(camion.getContenedor(), null);
	}
	
	@Test
	void test004_CuandoAUnCamionSeLeAsignaUnContenedor_LoConoce() {
		Dry contenedor= mock(Dry.class);
		
		camion.setContenedor(contenedor);
		
		assertEquals(camion.getContenedor(),contenedor);
	}

}
