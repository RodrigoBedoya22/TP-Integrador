package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.EmpresaNaviera;

class EmpresaNavieraTest {

	EmpresaNaviera empresaNaviera;
	ArrayList<BuqueViaje> listaDeViajes;
	ArrayList<CircuitoMaritimo> listaDeCircuitos;
	BuqueViaje viaje1;
    BuqueViaje viaje2;
    BuqueViaje viaje3;

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
		viaje1 = new BuqueViaje(new Buque(), new CircuitoMaritimo(), new Date());
        viaje2 = new BuqueViaje(new Buque(), new CircuitoMaritimo(), new Date());
        viaje3 = new BuqueViaje(new Buque(), new CircuitoMaritimo(), new Date());
		
        listaDeViajes = new ArrayList<BuqueViaje>();
        
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
		circuito1 = mock(CircuitoMaritimo.class);
		circuito2 = mock(CircuitoMaritimo.class);
		circuito3 = mock(CircuitoMaritimo.class);
	
        
		empresaNaviera.agregarcircuito(circuito1);
		empresaNaviera.agregarcircuito(circuito2);
		empresaNaviera.agregarcircuito(circuito3);
		
        assertEquals(3, empresaNaviera.getViajes().size());
        assertTrue(empresaNaviera.getCircuitos().contains(circuito1));
        assertTrue(empresaNaviera.getCircuitos().contains(circuito2));
        assertTrue(empresaNaviera.getCircuitos().contains(circuito3));
    }
	
		

}
