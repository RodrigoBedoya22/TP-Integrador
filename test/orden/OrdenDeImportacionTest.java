package orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;
import cliente.Cliente;
import contenedor.Contenedor;
import contenedor.Dry;
import empresa_naviera.BuqueViaje;
import empresa_transportista.Camion;
import empresa_transportista.Chofer;
import servicio.Lavado;
import servicio.Servicio;

class OrdenDeImportacionTest {
	
	Cliente cliente;
	OrdenImportacion orden;
	BlBasico carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	LocalDate fechaLimite;
	BuqueViaje viaje;
	Lavado servicioDeLavado;
	String nombreDeTerminalOrigen;
	String nombreDeTerminalDestino;
	Contenedor contenedor;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		carga= mock(BlBasico.class);
		contenedor = new Dry("aaaa", 1234567, 20.0, 40.0, 20.0, 1400.0, carga);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		servicios = new ArrayList<Servicio>();
		fechaLimite = mock(LocalDate.class);
		viaje = mock(BuqueViaje.class);
		nombreDeTerminalOrigen = "Terminal A";
		nombreDeTerminalDestino = "Terminal B";
		orden = new OrdenImportacion(cliente, contenedor, camion, chofer, servicios, fechaLimite, viaje, nombreDeTerminalOrigen, nombreDeTerminalDestino);

	}

	@Test
	void test001_UnaOrdenDeImportacionConoceASuCliente() {
		
		assertEquals(orden.getCliente(), cliente);
	}
	
	@Test
	void test002_UnaOrdenDeImportacionConoceSuCarga() {
		assertEquals(orden.getCarga(), carga);
	}
	
	@Test
	void test003_UnaOrdenDeImportacionConoceASuCamion() {	
		assertEquals(orden.getCamion(), camion);
	}
	
	@Test
	void test004_UnaOrdenDeImportacionConoceSuChofer() {
		assertEquals(orden.getChofer(), chofer);
	}
	
	@Test
	void test005_UnaOrdenDeImportacionConoceLosServiciosContratadosPorElCliente() {
		
		servicioDeLavado = new Lavado(10000);
		servicios.add(servicioDeLavado);
		assertEquals(orden.getServicios(), servicios);
	}
	
	@Test
	void test006_UnaOrdenDeImportacionConoceLaFechaDeLimiteDeRetiroDeLaCarga() {
		
		assertEquals(orden.getFechaLimite(), fechaLimite);
		
	}
	
	@Test
	void test007_UnaOrdenDeImportacionConoceElViajeDondeVendraLaCarga() {
		
		assertEquals(orden.getViaje(), viaje);
		
	}
	
	@Test
	void test008_UnaOrdenDeImportacionConoceElNombreDeLaTerminalOrigenDeLaQueSaldraSuCarga() {
		
		assertEquals(orden.getNombreTerminalOrigen(),nombreDeTerminalOrigen);
		
	}
	
	@Test
	void test009_UnaOrdenDeImportacionConoceElNombreDeLaTerminalDestinoDeLaQueLlegaraSuCarga() {
		assertEquals(orden.getNombreTerminalDestino(),nombreDeTerminalDestino);
		 
	}

}
