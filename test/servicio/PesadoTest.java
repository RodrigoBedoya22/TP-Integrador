package servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;
import cliente.Cliente;
import contenedor.Reefer;
import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import empresa_naviera.Tramo;
import orden.OrdenExportacion;
import terminal_portuaria.TerminalPortuaria;

class PesadoTest {

	Pesado pesado;
	Reefer contenedor, contenedor2;
	BlBasico carga;
	Cliente cliente;
	TerminalPortuaria terminal, terminal2;
	BuqueViaje viaje;
	
	@BeforeEach
	void setUp() throws Exception {
		
		pesado = new Pesado(400);
		carga = mock(BlBasico.class);
		contenedor2 = new Reefer("tata", 1234567, 5.00, 5.00, 10.00, 75.00, 10, carga);
		contenedor = new Reefer("pepe", 7654321, 2.00, 2.00, 10.00, 75.00, 20, carga);
		cliente = new Cliente ("Tomy", 45633467, "tomasagustinramos@gmail.com");
		Coordenada coordenada = new Coordenada(10.5, 20.7);
		terminal = new TerminalPortuaria ("ElAtlantico", coordenada);
		terminal2 = mock(TerminalPortuaria.class);
		viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA("ElAtlantico")).thenReturn(LocalDate.of(2023, 4, 23));
		when(viaje.getTramoActual()).thenReturn(new Tramo(terminal2, terminal, 22.0));
		
		
	}
	
	
	@Test
	void test001_UnServicioDePesadoSabeSuPrecioBaseFijo() {
		
		assertEquals(pesado.getPrecioFijo(), 400);
		
	}
	
	@Test
	void test002_ElServicioDePesadoPuedeCambiarDePrecio() {
		
		pesado.setPrecioFijo(500);
		assertEquals(pesado.getPrecioFijo(), 500);
		
	}
	
	@Test
	void test003_ElServicioDePesadoCobraEnBaseASuPrecioFijo() {
		
		ArrayList<Servicio> listaDeServicios = new ArrayList<Servicio>();
		listaDeServicios.add(pesado);
		
		OrdenExportacion orden = new OrdenExportacion(cliente, contenedor, null, null, listaDeServicios, viaje, "ElAtlantico", null);
	
		assertEquals(orden.calcularCostoTotalDeServicios(), 400.0);
		
	}
	

}
