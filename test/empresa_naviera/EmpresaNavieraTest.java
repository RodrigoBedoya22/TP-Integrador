package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

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
	
	@Test
	void test002_UnaEmpresaConoceLosViajeQueTiene() {
		BuqueViaje viaje1 = mock(BuqueViaje.class);
        BuqueViaje viaje2 = mock(BuqueViaje.class);
        BuqueViaje viaje3 = mock(BuqueViaje.class);
        
		empresaNaviera.agregarViaje(viaje1);
		empresaNaviera.agregarViaje(viaje2);
		empresaNaviera.agregarViaje(viaje3);
		
        assertEquals(3, empresaNaviera.getViajes().size());
        
        assertTrue(empresaNaviera.getViajes().contains(viaje1));
        assertTrue(empresaNaviera.getViajes().contains(viaje2));
        assertTrue(empresaNaviera.getViajes().contains(viaje3));
    }
	
	@Test
	void test003_UnaEmpresaConoceLosCircuitosQueTiene() {
		
		CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
		CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
		CircuitoMaritimo circuito3 = mock(CircuitoMaritimo.class);
	
		empresaNaviera.agregarCircuito(circuito1);
		empresaNaviera.agregarCircuito(circuito2);
		empresaNaviera.agregarCircuito(circuito3);
		
        assertEquals(3, empresaNaviera.getCircuitos().size());
        
        assertTrue(empresaNaviera.getCircuitos().contains(circuito1));
        assertTrue(empresaNaviera.getCircuitos().contains(circuito2));
        assertTrue(empresaNaviera.getCircuitos().contains(circuito3));
    }	

}
