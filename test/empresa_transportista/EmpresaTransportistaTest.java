package empresa_transportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTransportistaTest {
	
	EmpresaTransportista empresaTransportista;
	ArrayList<Camion> camiones;
	
	@BeforeEach
	void setUp() throws Exception {
		
		camiones = new ArrayList<Camion>();
		empresaTransportista = new EmpresaTransportista("Jamiroquai", camiones);
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
	
	@Test
	void test003_CuandoUnaEmpresaTransportistaAgregaUnCamion_SuListaDeCamionesAumenta() {

		Camion camion1 = mock(Camion.class);
		Camion camion2 = mock(Camion.class);
		empresaTransportista.agregarCamion(camion2);
		empresaTransportista.agregarCamion(camion1);
		
		assertEquals(empresaTransportista.getCamiones().size(), 2);
		assertTrue(empresaTransportista.getCamiones().contains(camion1));
		assertTrue(empresaTransportista.getCamiones().contains(camion2));
		
	}

}
