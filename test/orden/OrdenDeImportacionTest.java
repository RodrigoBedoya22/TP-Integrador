package orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;
import cliente.Cliente;
import contenedor.*;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.*;

class OrdenDeImportacionTest {
	
	Cliente cliente;
	OrdenImportacion orden;
	BlBasico carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	BuqueViaje viaje;
	Servicio servicioDeLavado;
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
		nombreDeTerminalOrigen = "Terminal A";
		nombreDeTerminalDestino = "Terminal B";
		viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA(nombreDeTerminalDestino)).thenReturn(LocalDate.of(2020, 12, 12));
		orden = new OrdenImportacion(cliente, contenedor, camion, chofer, servicios, viaje, nombreDeTerminalOrigen, nombreDeTerminalDestino);

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
		
		servicioDeLavado = new Lavado("Lavado", 10000);
		servicios.add(servicioDeLavado);
		assertEquals(orden.getServicios(), servicios);
	}
	
	@Test
	void test006_UnaOrdenDeImportacionConoceLaFechaDeLimiteDeRetiroDeLaCarga() {
		
		assertEquals(orden.getFechaLimite(), viaje.getFechaDeLlegadaA(nombreDeTerminalDestino).plusDays(1));
		
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
