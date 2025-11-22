package servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;
import cliente.Cliente;
import contenedor.Reefer;
import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import terminal_portuaria.TerminalPortuaria;

class ElectricidadTest {
	
	Electricidad electricidad;
	Reefer contenedor, contenedor2;
	BlBasico carga;
	Cliente cliente;
	TerminalPortuaria terminal;
	BuqueViaje viaje;

	@BeforeEach
	void setUp() throws Exception {
		electricidad = new Electricidad(400);
		carga = mock(BlBasico.class);
		contenedor2 = new Reefer("tata", 1234567, 5.00, 5.00, 10.00, 75.00, 10, carga);
		contenedor = new Reefer("pepe", 7654321, 2.00, 2.00, 10.00, 75.00, 20, carga);
		cliente = new Cliente ("Tomy", 45633467, "tomasagustinramos@gmail.com");
		Coordenada coordenada = new Coordenada(10.5, 20.7);
		terminal = new TerminalPortuaria ("ElAtlantico", coordenada);
		viaje = mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA("ElAtlantico")).thenReturn(LocalDate.of(2023, 4, 23));
		
	}
	

	@Test
	void test001_UnServicioDeElectricidadConoceSuPrecioBaseFijo() {
		assertEquals(electricidad.getPrecioFijo(), 400);
	}
	
	@Test
	void test002_UnServicioDeElectricidadNoPuedeTenerSuPrecioBaseFijoEnNegativo() {
		assertThrows(IllegalArgumentException.class, () -> new Electricidad(-500));
	}
	
	//@Test
	//void test003_ElServicioDeElectricidadCobraSuPrecioFijoEnBaseALaCantidadDeHorasPorConsumoTotalDeKwDeUnContenedor() {
	//	LocalDate fechaDeInicio = terminal.
		// int cantidadDeHorasDeConsumo = Duration.between(inicio, fin).toHours();
	// }

}
