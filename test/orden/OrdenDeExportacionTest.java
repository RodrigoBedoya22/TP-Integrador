package orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.*;
import cliente.Cliente;
import contenedor.*;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Lavado;
import servicio.Servicio;
import orden.*;

class OrdenDeExportacionTest {
	
	Cliente cliente;
	OrdenExportacion orden;
	BlBasico carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	BuqueViaje viaje;
	String nombreDeTerminalOrigen;
	String nombreDeTerminalDestino;
	Lavado servicioDeLavado;
	Contenedor contenedor;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		carga= mock(BlBasico.class);
		contenedor = new Dry("aaaa", 1234567, 20.0, 40.0, 20.0, 1400.0, carga);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		nombreDeTerminalOrigen = "Terminal A";
		nombreDeTerminalDestino = "Terminal B";
		servicios = new ArrayList<Servicio>();
		orden = new OrdenExportacion(cliente, contenedor , camion, chofer, servicios, viaje, nombreDeTerminalOrigen, nombreDeTerminalDestino);

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
	void test006_UnaOrdenDeExportacionConoceElViajeDondeSeLlevaraLaCarga() {
		assertEquals(orden.getViaje(), viaje);
	}
	
	@Test
	void test007_UnaOrdenDeExportacionConoceElNombreDeLaTerminalOrigenDeLaQueSaldraSuCarga() {
		assertEquals(orden.getNombreTerminalOrigen(),nombreDeTerminalOrigen);
		 
	}
	
	@Test
	void test008_UnaOrdenDeExportacionConoceElNombreDeLaTerminalDestinoDeLaQueLlegaraSuCarga() {
		assertEquals(orden.getNombreTerminalDestino(),nombreDeTerminalDestino);
		 
	}
	
	
	
}
