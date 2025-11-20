package empresa_transportista;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoferTest {

	Chofer chofer;
	
	@BeforeEach
	void setUp() throws Exception {
		
		chofer = new Chofer("Pedro", 45678987);
		
	}

	@Test
	void test001_UnChoferConoceSuNombre() {
		
		assertEquals(chofer.getNombre(), "Pedro");
	
	}
	
	@Test
	void test002_UnChoferConoceSuDni(){
		
		assertEquals(chofer.getDni(), 45678987);
		
	}

	@Test
	void test003_UnChoferPuedeCambiarDeNombre() {
		
		chofer.setNombre("Javier");
		assertEquals(chofer.getNombre(), "Javier");
		
	}
	
}
