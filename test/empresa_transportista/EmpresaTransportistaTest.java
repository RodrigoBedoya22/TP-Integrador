package empresa_transportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.BuqueViaje;
import empresa_naviera.EmpresaNaviera;

class EmpresaTransportistaTest {
	
	EmpresaTransportista empresaTransportista;

	@BeforeEach
	void setUp() throws Exception {
		
		empresaTransportista = new EmpresaTransportista("Jamiroquai");
	}

	@Test
	void test001_UnaEmpresaTransportistaConoceSuNombre() {
		
		assertEquals(empresaTransportista.getNombre(), "Jamiroquai");
		
    }

}
