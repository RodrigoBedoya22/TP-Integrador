package cliente;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.BlBasico;
import buque.Buque;
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
		BuqueViaje viaje= mock(BuqueViaje.class);
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		ArrayList<Servicio> serviciosRecibidos = new ArrayList<Servicio>();
				
		//se realiza la accion
		cliente.crearOrdenExportacion(viaje,carga, camion, chofer, serviciosRecibidos, terminal );
		
		//Se usa la terminal como un MOCK y se verifica que se le haya mandado el mensaje registrarOrden.
		verify(terminal).registrarOrden(any());
		
	}
	
	@Test
	void test007_CuandoUnClienteCreaUnaOrdenDeImportacion_LaTerminalLaRegistra() {
		
		TerminalPortuaria terminal = mock(TerminalPortuaria.class);
		BlBasico carga= mock(BlBasico.class);
		BuqueViaje viaje= mock(BuqueViaje.class);
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		LocalDate fechaLimite = LocalDate.of(2005, 9, 4);
		ArrayList<Servicio> serviciosRecibidos = new ArrayList<Servicio>();
				
		
		cliente.crearOrdenImportacion(viaje,carga, camion, chofer, serviciosRecibidos, fechaLimite, terminal);
		
		verify(terminal).registrarOrden(any());
		
	}
	

}
