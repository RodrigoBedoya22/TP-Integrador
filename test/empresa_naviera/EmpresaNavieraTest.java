package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaNavieraTest {

	EmpresaNaviera empresaNaviera;

	@BeforeEach
	void setUp() throws Exception {
		
		empresaNaviera = new EmpresaNaviera("Atlantida");
		
	}

	@Test
	void test001_UnaEmpresaConoceSuNombre() {
		
		assertEquals(empresaNaviera.getNombre(), "Atlantida");
		
	}

}
