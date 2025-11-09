package carga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import cliente.Cliente;
import terminal_portuaria.Coordenada;

class cargaTest {
	
	CargaBL carga;

	@BeforeEach
	void setUp() throws Exception {
		
		Cliente cliente = new Cliente("Kevin", 569245110, "kevin492@gmail.com");
		carga= new CargaBL("Comida", 25.3, cliente);
	
	}

	@Test
	void test001_UnaCargaConoceSuTipoDeProducto() {
		assertEquals(carga.getTipoDeProducto(), "Comida");
	}
	
	@Test
	void test002_UnaCargaConoceSuPeso() {
		assertEquals(carga.getPeso(), 25.3);
	}
	
	@Test
	void test003_UnaCargaConoceASuCliente() {
		Cliente cliente = carga.getPropietario();
		assertEquals(carga.getPropietario(), cliente);
	}


}
