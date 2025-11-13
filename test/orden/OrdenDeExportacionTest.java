package orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carga.*;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Lavado;
import servicio.Servicio;

class OrdenDeExportacionTest {
	
	Cliente cliente;
	OrdenExportacion orden;
	CargaBL carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	BuqueViaje viaje;
	Servicio lavado;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		carga= mock(CargaBL.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		lavado = mock(Lavado.class);
		servicios = new ArrayList<Servicio>();
		orden = new OrdenExportacion(cliente, carga, camion, chofer, servicios, viaje);

	}

	@Test
	void test001_UnaOrdenConoceASuCliente() {
		
		assertEquals(orden.getCliente(), cliente);
	}
	
	@Test
	void test002_UnaOrdenConoceSuCarga() {
		assertEquals(orden.getCarga(), carga);
	}
	
	@Test
	void test003_UnaOrdenConoceASuCamion() {	
		assertEquals(orden.getCamion(), camion);
	}
	
	@Test
	void test004_UnaOrdenConoceSuChofer() {
		assertEquals(orden.getChofer(), chofer);
	}
	
	@Test
	void test005_UnaOrdenConoceLosServiciosContratadosPorElCliente() {
		assertEquals(orden.getServicios(), servicios);
	}
	
	

}
