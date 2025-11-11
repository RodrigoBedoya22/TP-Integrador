package orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carga.*;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

class ordenTest {
	
	OrdenExportacion orden;
	CargaBL carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	BuqueViaje viaje;

	@BeforeEach
	void setUp() throws Exception {
		
		Cliente cliente = new Cliente("Rodrigo", 31234933, "rodro223@gmail.com");
		CargaBL carga= new CargaBL("Comida", 25.3, cliente);
		Camion camion = new Camion("ABC 123");
		Chofer chofer = new Chofer("Walter", 594544894);
		ArrayList<Servicio> servicios = new ArrayList<Servicio>();
		orden = new OrdenExportacion(cliente, carga, camion, chofer, servicios, viaje);

	}

	@Test
	void test001_UnaOrdenConoceASuCliente() {
		
		Cliente cliente = orden.getCliente();
		assertEquals(orden.getCliente(), cliente);
	}
	
	@Test
	void test002_UnaOrdenConoceSuCarga() {
		Carga carga = orden.getCarga();
		assertEquals(orden.getCarga(), carga);
	}
	
	@Test
	void test003_UnaOrdenConoceASuCamion() {	
		Camion camion = orden.getCamion();
		assertEquals(orden.getCamion(), camion);
	}
	
	@Test
	void test004_UnaOrdenConoceSuChofer() {
		Chofer chofer = orden.getChofer();
		assertEquals(orden.getChofer(), chofer);
	}
	
	

}
