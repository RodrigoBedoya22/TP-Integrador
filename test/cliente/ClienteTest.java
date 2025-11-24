package cliente;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;
import buque.Buque;
import contenedor.*;
import empresa_naviera.*;
import empresa_transportista.*;
import terminal_portuaria.*;
import servicio.Servicio;

class ClienteTest {
	
	Cliente cliente;
	@BeforeEach
	void setUp() throws Exception {
		
		cliente = new Cliente("Sergio", 12345678, "sergio@gmail.com");
	}
	
	@Test
	void test001_UnClienteConoceSuNombre() {
		assertEquals(cliente.getNombre(), "Sergio");
	}
	
	@Test
	void test002_UnClienteConoceSuDni() {
		assertEquals(cliente.getDni(), 12345678);
	}
	
	@Test
	void test003_UnClienteConoceSuEmail() {
		assertEquals(cliente.getEmail(), "sergio@gmail.com");
	}
	
	@Test
	void test004_UnClientePuedeCambiarDeNombre() {
		cliente.setNombre("Manolo");
		assertEquals(cliente.getNombre(), "Manolo");
	}
	
	@Test
	void test005_UnClientePuedeCambiarSuEmail() {
		
		cliente.setEmail("123sergio@gmail.com");
		assertEquals(cliente.getEmail(), "123sergio@gmail.com");
	}
	
	@Test
	void test006_CuandoUnClienteCreaUnaOrdenDeExportacion_LaTerminalLaRegistra() {
		//Se crea el contexto :terminal como MOCK y lo demas como DUMMY porque son para relleno
		TerminalPortuaria terminal = mock(TerminalPortuaria.class);
		BlBasico carga= mock(BlBasico.class);
		Contenedor contenedor = new Dry("aaaa", 1234567, 20.0, 40.0, 20.0, 1400.0, carga);
		BuqueViaje viaje= mock(BuqueViaje.class);
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		ArrayList<Servicio> serviciosRecibidos = new ArrayList<Servicio>();
		String nombreDeTerminalDestino = "Terminal B";
				
		//se realiza la accion
		cliente.crearOrdenExportacion(viaje,contenedor, camion, chofer, serviciosRecibidos, terminal, nombreDeTerminalDestino );
		
		//Se usa la terminal como un MOCK y se verifica que se le haya mandado el mensaje registrarOrden.
		verify(terminal).registrarOrden(any());
		
	}
	
	@Test
	void test007_CuandoUnClienteCreaUnaOrdenDeImportacion_LaTerminalLaRegistra() {
		
		String nombreDeTerminalDestino = "Terminal A";
		TerminalPortuaria terminal = mock(TerminalPortuaria.class);
		when(terminal.getNombre()).thenReturn(nombreDeTerminalDestino);
		BlBasico carga= mock(BlBasico.class);
		Contenedor contenedor = new Dry("aaaa", 1234567, 20.0, 40.0, 20.0, 1400.0, carga);
		BuqueViaje viaje= mock(BuqueViaje.class);
		when(viaje.getFechaDeLlegadaA(nombreDeTerminalDestino)).thenReturn(LocalDate.of(2020, 12, 12));
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		ArrayList<Servicio> serviciosRecibidos = new ArrayList<Servicio>();
		
		cliente.crearOrdenImportacion(viaje,contenedor, camion, chofer, serviciosRecibidos, terminal, nombreDeTerminalDestino);
		
		verify(terminal).registrarOrden(any());
		
	}
	

}
