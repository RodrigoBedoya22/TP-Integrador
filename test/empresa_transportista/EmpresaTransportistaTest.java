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
	
	@Test
	void test002_CuandoUnaEmpresaTransportistaAgregaUnNuevoChofer_SuListaDeChoferesAumenta() {

		Chofer chofer1 = mock(Chofer.class);
		Chofer chofer2 = mock(Chofer.class);
		Chofer chofer3 = mock(Chofer.class);
		Chofer chofer4 = mock(Chofer.class);
		empresaTransportista.agregarChofer(chofer1);
		empresaTransportista.agregarChofer(chofer2);
		empresaTransportista.agregarChofer(chofer3);
		empresaTransportista.agregarChofer(chofer4);
	
		assertEquals(empresaTransportista.getChoferes().size(), 4);
		
	}

}
