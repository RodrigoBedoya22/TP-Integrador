package carga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


import cliente.Cliente;
import terminal_portuaria.Coordenada;

class cargaTest {
	
	CargaBL cargaBL;
	CargaBLConsolidado cargaBLConsolidado;
	Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = new Cliente("Pedro", 12345678, "pedro@gmail.com");
		cargaBL= new CargaBL("Comida", 25.3, cliente);
		cargaBLConsolidado = new CargaBLConsolidado("Medicamentos", cliente);
	
	}

	@Test
	void test001_UnaCargaConoceSuTipoDeProducto() {
		
		assertEquals(cargaBL.getTipoDeProducto(), "Comida");
		assertEquals(cargaBLConsolidado.getTipoDeProducto(), "Medicamentos");
		
	}
	
	@Test
	void test002_UnaCargaConoceSuPeso() {
		
		cargaBLConsolidado.agregarCarga(cargaBL);
		
		assertEquals(cargaBL.getPeso(), 25.3);
		assertEquals(cargaBLConsolidado.getPeso(), 25.3);
	}
	
	@Test
	void test003_UnaCargaConoceASuCliente() {
		
		assertEquals(cargaBL.getPropietario(), cliente);
		assertEquals(cargaBLConsolidado.getPropietario(), cliente);
	}
	
	@Test
	void test004_CuandoUnContenedorConsolidadoAgregaUnaCarga_SuListaDeCargasAumenta() {
		
		CargaBL carga1 = cargaBL;
		CargaBLConsolidado carga2 = cargaBLConsolidado;
		
		cargaBLConsolidado.agregarCarga(carga1);
		cargaBLConsolidado.agregarCarga(carga2);
		
		assertEquals(cargaBLConsolidado.getCargas().size(), 2);
	}
	
	@Test
	void test005_UnContenedorConsolidadoNoPuedeAgregarUnaCargaDeUnDueñoDiferente() {
		
		CargaBL carga = mock(CargaBL.class);  
		
		assertThrows(IllegalArgumentException.class, () -> cargaBLConsolidado.agregarCarga(carga));
	}


}
