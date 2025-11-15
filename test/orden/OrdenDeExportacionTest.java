package orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.*;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Lavado;
import servicio.Servicio;

class OrdenDeExportacionTest {
	
	Cliente cliente;
	OrdenExportacion orden;
	BlBasico carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	BuqueViaje viaje;
	Lavado servicioDeLavado;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		carga= mock(BlBasico.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		servicios = new ArrayList<Servicio>();
		orden = new OrdenExportacion(cliente, carga, camion, chofer, servicios, viaje);

	} 

	@Test
	void test001_UnaOrdenDeExportacionConoceASuCliente() { 
		
		assertEquals(orden.getCliente(), cliente);
	}
	
	@Test
	void test002_UnaOrdenDeExportacionConoceSuCarga() {
		assertEquals(orden.getCarga(), carga);
	}
	
	@Test
	void test003_UnaOrdenDeExportacionConoceASuCamion() {	
		assertEquals(orden.getCamion(), camion);
	}
	
	@Test
	void test004_UnaOrdenDeExportacionConoceSuChofer() {
		assertEquals(orden.getChofer(), chofer);
	}
	
	@Test
	void test005_UnaOrdenDeExportacionConoceLosServiciosContratadosPorElCliente() {
		
		servicioDeLavado = new Lavado(10000);
		servicios.add(servicioDeLavado);
		assertEquals(orden.getServicios(), servicios);
		
	}
	
	@Test
	void test006_UnaOrdenDeExportacionConoceASuViaje() {
		assertEquals(orden.getViaje(), viaje);
	}
	
	
}
