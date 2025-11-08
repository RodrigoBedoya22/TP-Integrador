package empresa_transportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
