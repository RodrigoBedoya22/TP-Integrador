package bl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.*;
import static org.mockito.Mockito.*;
import cliente.Cliente;
import coordenada.Coordenada;

class BlTest {
	
	BlBasico cargaBL;
	BLConsolidado cargaBLConsolidado;
	Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = new Cliente("Pedro", 12345678, "pedro@gmail.com");
		cargaBL= new BlBasico("Comida", 25.3, cliente);
		cargaBLConsolidado = new BLConsolidado();
	}

	@Test
	void test001_UnaCargaConoceSuTipoDeProducto() {
		cargaBLConsolidado.agregarCarga(cargaBL);
		
		assertEquals(cargaBL.getTipoDeProducto(), "Comida");
		assertEquals(cargaBLConsolidado.getTipoDeProducto(), "Comida");
		
	}
	
	@Test
	void test002_UnaCargaConoceSuPeso() {
		cargaBLConsolidado.agregarCarga(cargaBL);
		
		assertEquals(cargaBL.getPeso(), 25.3);
		assertEquals(cargaBLConsolidado.getPeso(), 25.3);
	}
	
	@Test
	void test003_UnaCargaConoceASuCliente() {
		cargaBLConsolidado.agregarCarga(cargaBL);
		
		assertEquals(cargaBL.getPropietario(), cliente);
		assertEquals(cargaBLConsolidado.getPropietario(), cliente);
	}
	
	@Test
	void test004_CuandoUnContenedorConsolidadoAgregaUnaCarga_SuListaDeCargasAumenta() {
		
		BlBasico carga1 = cargaBL;
		BLConsolidado carga2 = cargaBLConsolidado;
		
		cargaBLConsolidado.agregarCarga(carga1);
		cargaBLConsolidado.agregarCarga(carga2);
		
		assertEquals(cargaBLConsolidado.getCargas().size(), 2);
	}
	
	@Test
	void test005_UnContenedorConsolidadoSacaUnaCarga_SuListaDeCargasDisminuye() {
		BlBasico carga1 = cargaBL;
		BLConsolidado carga2 = cargaBLConsolidado;
		
		cargaBLConsolidado.agregarCarga(carga1);
		cargaBLConsolidado.agregarCarga(carga2);
		cargaBLConsolidado.quitarCarga(carga1);
		cargaBLConsolidado.quitarCarga(carga2);

		
		assertEquals(cargaBLConsolidado.getCargas().size(), 0);
	}
	
	@Test
	void test006_UnContenedorConsolidadoNoPuedeSacarUnaCargaQueNoContieneEnSuListaDeCargas() {
		BlBasico carga1 = cargaBL;
		BLConsolidado carga2 = cargaBLConsolidado;
		
		cargaBLConsolidado.agregarCarga(carga1);
		cargaBLConsolidado.quitarCarga(carga2);

		assertFalse(cargaBLConsolidado.getCargas().contains(carga2));
		assertEquals(cargaBLConsolidado.getCargas().size(), 1);
	}

	
	@Test
	void test007_UnContenedorConsolidadoNoPuedeAgregarUnaCargaDeUnDueñoDiferente() {
		cargaBLConsolidado.agregarCarga(cargaBL);
		BlBasico carga = mock(BlBasico.class);
		
		assertThrows(IllegalArgumentException.class, () -> cargaBLConsolidado.agregarCarga(carga));
	}
	
	

}
